package ro.jtonic.handson.springweb.init;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

/**
 * Created by jtonic on 8/31/13.
 */
public class CinemaWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        addListeners(servletContext);

//        addFilters(servletContext);

        addServlets(servletContext);

    }

    private void addListeners(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(CinemaConfig.class);

        servletContext.addListener(new ContextLoaderListener(context));
        servletContext.setInitParameter("defaultHtmlEscape", "true");
    }

    private void addServlets(ServletContext servletContext) {
        DispatcherServlet servlet = new DispatcherServlet();
        // no explicit configuration reference here: everything is configured in the root container for simplicity
        servlet.setContextConfigLocation("");

        ServletRegistration.Dynamic appServlet = servletContext.addServlet("dispatcher", servlet);
        appServlet.setLoadOnStartup(1);
        appServlet.setAsyncSupported(true);

        Set<String> mappingConflicts = appServlet.addMapping("/");
        if (!mappingConflicts.isEmpty()) {
            throw new IllegalStateException("'dispatcher' cannot be mapped to '/' under Tomcat versions <= 7.0.14");
        }
    }

    private void addFilters(ServletContext servletContext) {
        servletContext.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
    }
}
