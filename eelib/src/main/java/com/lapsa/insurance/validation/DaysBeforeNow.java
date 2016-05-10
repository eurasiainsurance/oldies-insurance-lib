package com.lapsa.insurance.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = DaysBeforeNowConstraintValidator.class)
public @interface DaysBeforeNow {

    Mode mode();

    int value();

    String message() default "{com.lapsa.insurance.validation.DaysBeforeNow.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
