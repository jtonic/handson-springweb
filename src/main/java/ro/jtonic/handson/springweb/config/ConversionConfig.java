package ro.jtonic.handson.springweb.config;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.core.convert.support.ConversionServiceFactory;
import ro.jtonic.handson.springweb.conversion.String2TeacherConverter;

/**
 * Created by jtonic on 9/1/13.
 */
@Configuration
public class ConversionConfig {

    @Bean
    public ConversionService conversionService() {
        final ConversionServiceFactoryBean conversionServiceFactoryBean = conversionServiceFactoryBean();
        final ConversionService conversionService = conversionServiceFactoryBean.getObject();
        ConverterRegistry converterRegistry = (ConverterRegistry) conversionService;
        ConversionServiceFactory.registerConverters(Sets.newHashSet(new String2TeacherConverter()), converterRegistry);
        return conversionService;
    }

    @Bean
    protected ConversionServiceFactoryBean conversionServiceFactoryBean() {
        return new ConversionServiceFactoryBean();
    }

}
