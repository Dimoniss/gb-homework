package gb.spring.lesson_4_homework.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CompanyValidation.class)
public @interface Company {
    String message() default "The company is not in the provided list";
    Class<?>[] groups() default {};
    public abstract Class<? extends Payload>[] payload() default {};
}
