package kz.theeurasia.policy.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import kz.theeurasia.policy.osgpovts.MessageBundleCode;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = IdNumberConstraintValidator.class)
public @interface IdNumber {

    MessageBundleCode messageCode() default MessageBundleCode.ID_NUMBER_CANT_BE_EMPTY;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}