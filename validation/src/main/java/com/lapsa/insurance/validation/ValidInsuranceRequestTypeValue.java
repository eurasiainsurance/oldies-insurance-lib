package com.lapsa.insurance.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.lapsa.insurance.crm.InsuranceRequestType;
import com.lapsa.insurance.validation.validators.ValidInsuranceRequestTypeValueConstraintValidator;
import com.lapsa.validation.ValidationMode;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidInsuranceRequestTypeValueConstraintValidator.class)
public @interface ValidInsuranceRequestTypeValue {

    InsuranceRequestType[] denied() default {};

    InsuranceRequestType[] permited() default {};

    ValidationMode mode() default ValidationMode.AUTO;

    String message() default "{com.lapsa.insurance.validation.ValidInsuranceRequestTypeValue.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
