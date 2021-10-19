package local.tin.tests.spring.boot.modifiers.advicers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 *
 * @author benitodarder
 */
@ControllerAdvice
public class SimpleResposeAdvicer implements ResponseBodyAdvice<Object> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleResposeAdvicer.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
            Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (serverHttpRequest instanceof ServletServerHttpRequest && serverHttpResponse instanceof ServletServerHttpResponse) {
            LOGGER.info("Body was read!!");
            LOGGER.info("And it was:\n" + (String) o);
        }
        return o;
    }
}
