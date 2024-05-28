package lazy;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Lazy {
    String id() default "";
    String xpath() default "";
    String css() default "";
    String name() default "";
    String className() default "";
    String tagName() default "";
    String linkText() default "";
    String partialLinkText() default "";
    int timeout() default 0;
}
