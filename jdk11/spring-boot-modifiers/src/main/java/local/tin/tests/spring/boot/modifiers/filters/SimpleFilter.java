package local.tin.tests.spring.boot.modifiers.filters;

import java.io.IOException;
import org.springframework.stereotype.Component;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author benitodarder
 */
@Component
public class SimpleFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("Filter initialized!");
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        LOGGER.info("Filter doFilter starts!");
        arg2.doFilter(arg0, arg1);
        LOGGER.info("Filter doFilter ends!");
    }

    @Override
    public void destroy() {
        LOGGER.info("Filter destroyed!");
    }

}
