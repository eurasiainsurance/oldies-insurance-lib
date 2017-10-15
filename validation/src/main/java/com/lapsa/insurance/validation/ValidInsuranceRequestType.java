package com.lapsa.insurance.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.lapsa.insurance.elements.InsuranceRequestType;
import com.lapsa.insurance.validation.validators.ValidInsuranceRequestTypeConstraintValidator;

import tech.lapsa.javax.validation.ValidationMode;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidInsuranceRequestTypeConstraintValidator.class)
public @interface ValidInsuranceRequestType {

    InsuranceRequestType[] denied() default {};

    InsuranceRequestType[] permited() default {};

    ValidationMode mode() default ValidationMode.AUTO;

    String message() default "{com.lapsa.insurance.validation.ValidInsuranceRequestType.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
