package ro.jtonic.handson.springweb.init;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ro.jtonic.handson.springweb.config.ConversionConfig;
import ro.jtonic.handson.springweb.controllers.CinemaController;
import ro.jtonic.handson.springweb.support.WebMvcContextConfigurationSupport;

/**
 * Created by jtonic on 8/25/13.
 */
@Configuration
@Import({WebMvcContextConfigurationSupport.class, ServicesConfig.class, ConversionConfig.class, JpaDataConfiguration.class})
//@ImportResource("classpath:META-INF/applicationContext-security.xml")
@ComponentScan(basePackages = {"ro.jtonic.handson.springweb"})
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
