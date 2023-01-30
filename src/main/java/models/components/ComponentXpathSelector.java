package models.components;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE})
public @interface ComponentXpathSelector {
    String value();
}
