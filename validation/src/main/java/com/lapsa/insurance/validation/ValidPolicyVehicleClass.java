package com.lapsa.insurance.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.lapsa.insurance.validation.validators.ValidPolicyVehicleClassConstraintValidator;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidPolicyVehicleClassConstraintValidator.class)
public @interface ValidPolicyVehicleClass {

    String message() default "{com.lapsa.insurance.validation.ValidPolicyVehicleClass.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
