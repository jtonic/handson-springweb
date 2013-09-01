package ro.jtonic.handson.springweb.conversion;

import com.google.common.base.Strings;
import org.springframework.core.convert.converter.Converter;
import ro.jtonic.handson.springweb.model.Teacher;

/**
 * Created by jtonic on 9/1/13.
 */
public class String2TeacherConverter implements Converter<String, Teacher> {
    @Override
    public Teacher convert(String source) {
        if (Strings.isNullOrEmpty(source)) {
            return null;
        }
        return new Teacher(source);
    }
}
