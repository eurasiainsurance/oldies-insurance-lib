package com.lapsa.insurance.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.lapsa.insurance.validation.validators.ValidVehicleYearOfIssueConstraintValidator;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidVehicleYearOfIssueConstraintValidator.class)
public @interface ValidVehicleYearOfIssue {

    String message() default "{com.lapsa.insurance.validation.ValidVehicleYearOfIssue.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int minValue() default 1950;

}
