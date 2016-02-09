package kz.theeurasia.policy.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredExpirienceClassEnum;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidInsuranceExpirienceClassConstraintValidator.class)
public @interface ValidInsuranceExpirienceClass {

    InsuredExpirienceClassEnum[] invalidValues() default { InsuredExpirienceClassEnum.UNSPECIFIED };

    String message() default "{kz.theeurasia.policy.validator.ValidInsuranceExpirienceClass.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
