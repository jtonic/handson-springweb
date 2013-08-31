package ro.jtonic.handson.springweb.support;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/**
 * Created by jtonic on 8/31/13.
 */
@Configuration
public class WebMvcContextConfigurationSupport extends WebMvcConfigurationSupport {

    @Override
    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        final RequestMappingHandlerAdapter adapter = super.requestMappingHandlerAdapter();
        final ConfigurableWebBindingInitializer webBindingInitializer = (ConfigurableWebBindingInitializer) adapter.getWebBindingInitializer();
        webBindingInitializer.setDirectFieldAccess(true);
        return adapter;
    }
}
