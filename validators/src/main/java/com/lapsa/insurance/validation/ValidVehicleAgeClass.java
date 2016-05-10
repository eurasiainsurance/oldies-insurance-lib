package com.lapsa.insurance.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.lapsa.insurance.elements.VehicleAgeClass;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidVehicleAgeClassConstraintValidator.class)
public @interface ValidVehicleAgeClass {

    VehicleAgeClass[] invalidValues() default {};

    String message() default "{com.lapsa.insurance.validation.ValidVehicleAgeClass.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
