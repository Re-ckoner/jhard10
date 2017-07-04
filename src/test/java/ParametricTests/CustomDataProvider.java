package ParametricTests;

import com.tngtech.java.junit.dataprovider.DataProvider;

import java.lang.annotation.Annotation;

/**
 * Created by Andy on 05.07.2017.
 */
public class CustomDataProvider extends DataProvider {

    public String[] value() {
        return new String[0];
    }

    public String splitBy() {
        return null;
    }

    public boolean convertNulls() {
        return false;
    }

    public boolean trimValues() {
        return false;
    }

    public String format() {
        return null;
    }

    public boolean equals(Object obj) {
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return null;
    }

    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
