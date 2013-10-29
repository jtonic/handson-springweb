package ro.jtonic.handson.springweb.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import ro.jtonic.handson.springweb.config.ConversionConfig;
import ro.jtonic.handson.springweb.model.Teacher;

import java.util.Calendar;
import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by jtonic on 9/1/13.
 */
@ContextConfiguration(classes = {ConversionTest.class})
@Configuration
@Import({ConversionConfig.class})
public class ConversionTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private FormattingConversionService formattingConversionService;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;

    @Test
    public void testConversion() {
        String teacherName = "antonel";
        final Teacher teacher = conversionService.convert(teacherName, Teacher.class);
        assertThat(teacher.getName()).isEqualTo(teacherName);
    }

    @Test(enabled = false)
    public void testDateFormat() {
        String dateStr =  "1970-01-29";
        final Date date = formattingConversionService.convert(dateStr, Date.class);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        assertThat(calendar.get(Calendar.DAY_OF_MONTH)).isEqualTo(1);
    }

}
