package kz.theeurasia.policy.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryRegionDict;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidCountryRegionConstraintValidator.class)
public @interface ValidCountryRegion {

    CountryRegionDict[] invalidValues() default { CountryRegionDict.TEMPORARY_ENTRY,
	    CountryRegionDict.TEMPORARY_REGISTRATION, CountryRegionDict.UNSPECIFIED };

    String message() default "{kz.theeurasia.policy.validator.ValidCountryRegion.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
