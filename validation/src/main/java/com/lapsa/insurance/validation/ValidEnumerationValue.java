package com.lapsa.insurance.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidEnumerationValueConstraintValidator.class)
public @interface ValidEnumerationValue {

    // запрещено все, что не разрешено
    public static final int DENY_ALL_NOT_ALLOWED = 1;

    // разрешено все, что не запрещено
    public static final int ALLOW_ALL_NOT_DENIED = 2;

    String[] denyValues() default {};

    String[] allowValues() default {};

    int mode() default ALLOW_ALL_NOT_DENIED;

    String message() default "{com.lapsa.insurance.validation.ValidEnumerationValue.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
