package demo.cloud.common.core.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.cloud.common.core.exception.DemoException;
import demo.cloud.common.core.response.Resp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.CharSet;
import org.apache.tomcat.util.buf.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component
public class HttpHandler {

    @Autowired
    private ObjectMapper objectMapper;

    public <T> void printServerResponseToWeb(Resp<T> serverResponseEntity) {
        if (serverResponseEntity == null) {
            log.info("print obj is null");
            return;
        }

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (requestAttributes == null) {
            log.error("requestAttributes is null, can not print to web");
            return;
        }
        HttpServletResponse response = requestAttributes.getResponse();
        if (response == null) {
            log.error("httpServletResponse is null, can not print to web");
            return;
        }
        log.error("response error: " + serverResponseEntity.getMsg());
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            //printWriter.write(XssUtil.clean(objectMapper.writeValueAsString(serverResponseEntity)));
        } catch (IOException e) {
            throw new DemoException("io 异常", e);
        }
    }

}
