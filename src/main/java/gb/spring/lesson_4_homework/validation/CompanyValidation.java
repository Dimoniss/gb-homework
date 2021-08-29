package gb.spring.lesson_4_homework.validation;

import gb.spring.lesson_4_homework.service.CompanyService;
import lombok.RequiredArgsConstructor;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class CompanyValidation implements ConstraintValidator<Company, String> {

    private final CompanyService companyService;

    @Override
    public void initialize(Company constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return companyService.presenceInTheList(s);
    }
}
