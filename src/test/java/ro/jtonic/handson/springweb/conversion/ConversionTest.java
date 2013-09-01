package ro.jtonic.handson.springweb.conversion;

import org.fest.assertions.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import ro.jtonic.handson.springweb.config.ConversionConfig;
import ro.jtonic.handson.springweb.model.Teacher;

/**
 * Created by jtonic on 9/1/13.
 */
@ContextConfiguration(classes = {ConversionTest.class})
@Configuration
@Import({ConversionConfig.class})
public class ConversionTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ConversionService conversionService;

    @Test
    public void testConversion() {
        String teacherName = "antonel";
        final Teacher teacher = conversionService.convert(teacherName, Teacher.class);
        Assertions.assertThat(teacher.getName()).isEqualTo(teacherName);
    }

}
