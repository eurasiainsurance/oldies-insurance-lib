package kz.theeurasia.policy.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.lapsa.kz.country.KZArea;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidKZAreaConstraintValidator.class)
public @interface ValidKZArea {

    KZArea[] invalidValues() default {};

    String message() default "{kz.theeurasia.policy.validator.ValidKZArea.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
