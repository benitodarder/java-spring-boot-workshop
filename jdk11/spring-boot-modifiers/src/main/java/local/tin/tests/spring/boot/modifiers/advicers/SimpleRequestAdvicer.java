package local.tin.tests.spring.boot.modifiers.advicers;

import java.lang.reflect.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

/**
 *
 * @author benitodarder
 */
@ControllerAdvice
public class SimpleRequestAdvicer extends RequestBodyAdviceAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleRequestAdvicer.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        LOGGER.info("SimpleRequestAdvicer supports!!");
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {

        LOGGER.info("SimpleRequestAdvicer afterBodyRead!!");
        LOGGER.info("And it was:\n{}", (String) body);

        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }

}
