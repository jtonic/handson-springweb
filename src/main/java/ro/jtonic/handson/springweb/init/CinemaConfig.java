package ro.jtonic.handson.springweb.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ro.jtonic.handson.springweb.config.ConversionConfig;
import ro.jtonic.handson.springweb.controllers.CinemaController;
import ro.jtonic.handson.springweb.support.WebMvcContextConfigurationSupport;

/**
 * Created by jtonic on 8/25/13.
 */
@Configuration
@Import({WebMvcContextConfigurationSupport.class, ServicesConfig.class, ConversionConfig.class})
@EnableWebMvc
public class CinemaConfig {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public CinemaController cinemaController() {
        return new CinemaController();
    }

}
