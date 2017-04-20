package com.lapsa.insurance.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.lapsa.insurance.elements.VehicleClass;
import com.lapsa.insurance.validation.validators.ValidVehicleClassConstraintValidator;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidVehicleClassConstraintValidator.class)
public @interface ValidVehicleClass {

    VehicleClass[] invalidValues() default {};

    String message() default "{com.lapsa.insurance.validation.ValidVehicleClass.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
