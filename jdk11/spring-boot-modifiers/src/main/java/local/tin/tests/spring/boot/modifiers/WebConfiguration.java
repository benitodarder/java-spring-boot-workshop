package local.tin.tests.spring.boot.modifiers;

import local.tin.tests.spring.boot.modifiers.interceptors.SimpleInterceptor;
import local.tin.tests.spring.boot.modifiers.interceptors.SimpleInterceptorToo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author benitodarder
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private SimpleInterceptor simpleInterceptor;

    @Autowired
    private SimpleInterceptorToo simpleInterceptorToo;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(simpleInterceptor).addPathPatterns("/**");
        registry.addInterceptor(simpleInterceptorToo).addPathPatterns("/upperCaser/**");
    }
}
