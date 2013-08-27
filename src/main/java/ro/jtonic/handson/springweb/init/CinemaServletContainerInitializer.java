package ro.jtonic.handson.springweb.init;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

/**
 * Created by jtonic on 8/25/13.
 */
public class CinemaServletContainerInitializer implements ServletContainerInitializer {
/*    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        final ServletRegistration.Dynamic registration = ctx.addServlet("hello", MyServlet.class);
        registration.setLoadOnStartup(1);
        registration.addMapping("/hello");
    }*/
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        final AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(CinemaConfig.class);

        DispatcherServlet servlet = new DispatcherServlet(webApplicationContext);
        final ServletRegistration.Dynamic registration = ctx.addServlet("dispatcher", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
