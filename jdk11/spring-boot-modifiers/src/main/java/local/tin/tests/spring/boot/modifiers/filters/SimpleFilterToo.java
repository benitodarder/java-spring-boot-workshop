package local.tin.tests.spring.boot.modifiers.filters;

import java.io.IOException;
import org.springframework.stereotype.Component;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author benitodarder
 */
@Component
public class SimpleFilterToo implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleFilterToo.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        LOGGER.info("Filter initialized!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("doFilter starts!");
        if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
            LOGGER.warn("LoggingFilter just supports HTTP requests");
        } else {

            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            SimpleHttpServletRequestWrapper requestWrapper = new SimpleHttpServletRequestWrapper(httpRequest);
            SimpleHttServletResponseWrapper responseWrapper = new SimpleHttServletResponseWrapper(httpResponse);
            String requestBody = requestWrapper.getContent();
            long t0 = System.currentTimeMillis();

            try {

                filterChain.doFilter(requestWrapper, responseWrapper);

                LOGGER.info("{} {} - {}{} - {}ms\nRequest body:\n{}\nResponse body:\n{}\n==============================================", requestWrapper.getMethod(), responseWrapper.getStatus(), requestWrapper.getRequestURL().toString(), requestWrapper.getQueryString() != null ? ("?" + requestWrapper.getQueryString()) : "", (System.currentTimeMillis() - t0), requestBody, responseWrapper.getContent());
                httpResponse.getOutputStream().write(responseWrapper.getContentAsBytes());

            } catch (Exception e) {
                LOGGER.error("{} {} - {}{} - {}ms\nRequest body:\n{}\nException message:\n{}\n==============================================", requestWrapper.getMethod(), responseWrapper.getStatus(), requestWrapper.getRequestURL().toString(), requestWrapper.getQueryString() != null ? ("?" + requestWrapper.getQueryString()) : "", (System.currentTimeMillis() - t0), requestBody, e.getMessage());
                httpResponse.getOutputStream().write(e.getMessage().getBytes());
            }

        }
        LOGGER.info("doFilter ends!");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        LOGGER.info("Filter destroyed!");
    }

}
