package ro.jtonic.handson.springweb.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.jtonic.handson.springweb.services.BookSearchCriteriaService;

/**
 * Created by jtonic on 8/31/13.
 */
@Configuration
public class ServicesConfig {

    @Bean(name = "criteriaService")
    public BookSearchCriteriaService bookSearchCriteriaService() {
        return new BookSearchCriteriaService();
    }
}
