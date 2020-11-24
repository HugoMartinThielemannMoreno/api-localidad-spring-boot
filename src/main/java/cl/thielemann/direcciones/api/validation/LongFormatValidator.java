package cl.thielemann.direcciones.api.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LongFormatValidator implements ConstraintValidator<LongFormat, String> {

    @Override
    public void initialize(LongFormat constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches("^[0-9]*$");
    }
}
