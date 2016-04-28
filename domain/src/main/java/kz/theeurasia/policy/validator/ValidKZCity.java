package kz.theeurasia.policy.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.lapsa.kz.country.KZCity;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidKZCityConstraintValidator.class)
public @interface ValidKZCity {

    KZCity[] invalidValues() default {};

    String message() default "{kz.theeurasia.policy.validator.ValidKZCity.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
