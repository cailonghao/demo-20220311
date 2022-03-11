package demo.cloud.common.core.common.security.filter;


import demo.cloud.api.auth.bo.UserInfoInTokenBo;
import demo.cloud.api.auth.feign.TokenFeignClient;
import demo.cloud.common.core.common.security.AuthUserContext;
import demo.cloud.common.core.common.security.adapter.AuthConfigAdapter;
import demo.cloud.common.core.handle.HttpHandler;
import demo.cloud.common.core.response.Resp;
import demo.cloud.common.core.response.RespEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@Component
public class AuthFilter implements Filter {

    @Autowired
    private AuthConfigAdapter authConfigAdapter;
    @Autowired
    private HttpHandler httpHandler;
    @Autowired
    private TokenFeignClient tokenFeignClient;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("----------***----------default auth filter loading ......");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //验证规则

        List<String> excludePathPatterns = authConfigAdapter.excludePathPattern();

        // 如果匹配不需要授权的路径，就不需要校验是否需要授权
        if (!excludePathPatterns.isEmpty()) {
            for (String excludePathPattern : excludePathPatterns) {
                AntPathMatcher pathMatcher = new AntPathMatcher();
                if (pathMatcher.match(excludePathPattern, req.getRequestURI())) {
                    chain.doFilter(req, resp);
                    return;
                }
            }
        }
        String accessToken = req.getHeader("Authorization");
        if (StringUtils.isEmpty(accessToken)) {
            httpHandler.printServerResponseToWeb(Resp.fail(RespEnum.UNAUTHORIZED));
            return;
        }

        // 校验token，并返回用户信息
        Resp<UserInfoInTokenBo> userInfoInTokenVoServerResponseEntity = tokenFeignClient
                .checkToken(accessToken);
        if (!userInfoInTokenVoServerResponseEntity.isSuccess()) {
            httpHandler.printServerResponseToWeb(Resp.fail(RespEnum.UNAUTHORIZED));
            return;
        }
        UserInfoInTokenBo userInfoInToken = userInfoInTokenVoServerResponseEntity.getData();

        // 需要用户角色权限，就去根据用户角色权限判断是否
//        if (!checkRbac(userInfoInToken,req.getRequestURI(), req.getMethod())) {
//            httpHandler.printServerResponseToWeb(ServerResponseEntity.fail(ResponseEnum.UNAUTHORIZED));
//            return;
//        }

        try {
            // 保存上下文
            AuthUserContext.set(userInfoInToken);

            chain.doFilter(req, resp);
        }
        finally {
            AuthUserContext.clean();
        }

    }


}
