package demo.cloud.common.core.common.security.filter;


import demo.cloud.common.core.api.auth.bo.UserInfoInTokenBo;
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
            httpHandler.printServerResponseToWeb(ServerResponseEntity.fail(ResponseEnum.UNAUTHORIZED));
            return;
        }
    }


}
