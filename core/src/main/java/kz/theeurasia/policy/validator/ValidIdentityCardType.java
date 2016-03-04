package kz.theeurasia.policy.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import kz.theeurasia.esbdproxy.domain.dict.general.IdentityCardTypeDict;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidIdentityCardTypeConstraintValidator.class)
public @interface ValidIdentityCardType {
    IdentityCardTypeDict[] invalidValues() default { IdentityCardTypeDict.UNSPECIFIED };

    String message() default "{kz.theeurasia.policy.validator.ValidIdentityCardType.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}