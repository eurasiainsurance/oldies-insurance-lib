package kz.theeurasia.policy.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidVehicleClassConstraintValidator.class)
public @interface ValidVehicleClass {

    VehicleClassDict[] invalidValues() default { VehicleClassDict.UNSPECIFIED };

    String message() default "{kz.theeurasia.policy.validator.ValidVehicleClass.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
