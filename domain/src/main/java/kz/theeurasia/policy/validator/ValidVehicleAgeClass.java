package kz.theeurasia.policy.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleAgeClassDict;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidVehicleAgeClassConstraintValidator.class)
public @interface ValidVehicleAgeClass {

    VehicleAgeClassDict[] invalidValues() default {};

    String message() default "{kz.theeurasia.policy.validator.ValidVehicleAgeClass.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
