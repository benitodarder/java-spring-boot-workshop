package local.tin.tests.spring.boot.modifiers.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author benitodarder
 */
@WebFilter(urlPatterns = "/upperCaser/")
public class SimpleWebFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleWebFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        LOGGER.info("upperCaser WebFilter initialized!");
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        LOGGER.info("upperCaser WebFilter before doFilter");
        arg2.doFilter(arg0, arg1);
        LOGGER.info("upperCaser WebFilter after doFilter");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        LOGGER.info("upperCaser WebFilter destroyed!");
    }


}
