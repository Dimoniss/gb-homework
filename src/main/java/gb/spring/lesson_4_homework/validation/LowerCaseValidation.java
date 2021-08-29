package gb.spring.lesson_4_homework.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LowerCaseValidation implements ConstraintValidator<LowerCase, String> {

    @Override
    public void initialize(LowerCase constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.equals(s.toLowerCase());
    }


}
