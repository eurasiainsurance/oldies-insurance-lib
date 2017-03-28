package com.lapsa.insurance.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidHumanNameConstraintValidator.class)
public @interface ValidHumanName {

    String message() default "{com.lapsa.insurance.validation.ValidHumanName.message}";

    String[] languagesAllowed() default { "ru", "kk", "en" };

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean trimSpaces() default true;

}