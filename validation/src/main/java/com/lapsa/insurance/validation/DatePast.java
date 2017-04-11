package com.lapsa.insurance.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.lapsa.insurance.validation.validators.DatePastConstraintValidator;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = DatePastConstraintValidator.class)
public @interface DatePast {

    String message() default "{com.lapsa.insurance.validation.DatePast.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
