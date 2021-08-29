package gb.spring.lesson_4_homework.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LowerCaseValidation.class)
public @interface LowerCase {
    String message() default "Product name is not lowercase";
    Class<?>[] groups() default {};
    public abstract Class<? extends Payload>[] payload() default {};
}
