package com.lapsa.insurance.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.lapsa.insurance.elements.IdentityCardType;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidIdentityCardTypeConstraintValidator.class)
public @interface ValidIdentityCardType {
    IdentityCardType[] invalidValues() default {};

    String message() default "{com.lapsa.insurance.validation.ValidIdentityCardType.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
