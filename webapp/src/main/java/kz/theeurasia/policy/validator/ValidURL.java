package kz.theeurasia.policy.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidURLConstraintValidator.class)
public @interface ValidURL {
    boolean checkForProtocol() default true;

    String message() default "{kz.theeurasia.policy.validator.ValidURL.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
