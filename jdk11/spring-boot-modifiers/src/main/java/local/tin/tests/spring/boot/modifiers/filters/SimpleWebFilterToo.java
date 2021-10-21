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
@WebFilter(urlPatterns = "/lowerCaser/")
public class SimpleWebFilterToo implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleWebFilterToo.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("SimpleWebFilterToo initialized!");
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        LOGGER.info("SimpleWebFilterToo doFilter starts");
        arg2.doFilter(arg0, arg1);
        LOGGER.info("SimpleWebFilterToo doFilter ends");
    }

    @Override
    public void destroy() {
        LOGGER.info("SimpleWebFilterToo destroyed!");
    }


}
