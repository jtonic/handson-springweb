package ro.jtonic.handson.springweb.model;

import com.google.common.base.Objects;

/**
 * Created by jtonic on 9/1/13.
 */
public class Teacher {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
