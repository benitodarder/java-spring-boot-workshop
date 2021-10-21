package local.tin.tests.spring.boot.modifiers.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author benitodarder
 */
@Component
public class SimpleInterceptorToo implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleInterceptorToo.class);

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3) throws Exception {
        LOGGER.info("SimpleInterceptorToo afterCompletion");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model) throws Exception {
        LOGGER.info("SimpleInterceptorToo postHandle");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        LOGGER.info("SimpleInterceptorToo preHandle");
        return true;
    }
}