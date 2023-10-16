package annotations;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jdk.jfr.SettingDefinition;

import javax.annotation.RegEx;
import java.beans.JavaBean;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ISBN {
    public int length() default 17;
    public String isbnRegex() default "^ISBN.*$";
}
