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
    private final long createdAt;

    public SimpleWebFilter() {
        this.createdAt = System.currentTimeMillis();
    }
    
    

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("WebFilter initialized!");
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        LOGGER.info("WebFilter doFilter starts!! Created at:  {}", createdAt);
        arg2.doFilter(arg0, arg1);
        LOGGER.info("WebFilter doFilter ends!!");
    }

    @Override
    public void destroy() {
        LOGGER.info("WebFilter destroyed!");
    }

}
