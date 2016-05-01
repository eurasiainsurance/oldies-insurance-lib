package kz.theeurasia.policy.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.lapsa.insurance.elements.InsuredAgeClass;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidInsuranceAgeClassConstraintValidator.class)
public @interface ValidInsuranceAgeClass {

    InsuredAgeClass[] invalidValues() default {};

    String message() default "{kz.theeurasia.policy.validator.ValidInsuranceAgeClass.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
