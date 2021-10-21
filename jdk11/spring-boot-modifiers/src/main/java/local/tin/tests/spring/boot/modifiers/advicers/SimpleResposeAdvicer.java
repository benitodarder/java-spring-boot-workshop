package local.tin.tests.spring.boot.modifiers.advicers;

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
        LOGGER.info("SimpleResposeAdvicer supports!!");
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
            Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (serverHttpRequest instanceof ServletServerHttpRequest && serverHttpResponse instanceof ServletServerHttpResponse) {
            LOGGER.info("SimpleResposeAdvicer beforeBodyWrite!!");
            if (o instanceof String) {
                LOGGER.info("And it's going to be:\n{}", (String) o);
            } else if (o != null) {
                LOGGER.info("And it is an instance of:\n{}" , o.getClass().getCanonicalName());
            } else {
                 LOGGER.info("And it is going to be null...Pfff... Whatever... Meh");
            }
        }
        return o;
    }
}
