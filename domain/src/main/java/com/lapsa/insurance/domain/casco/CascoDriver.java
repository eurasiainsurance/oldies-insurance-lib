package com.lapsa.insurance.domain.casco;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;

import com.lapsa.commons.function.MyStrings;
import com.lapsa.insurance.domain.Driver;
import com.lapsa.insurance.domain.PersonalData;

public class CascoDriver extends Driver {
    private static final long serialVersionUID = 6781864890008476284L;
    private static final int PRIME = 113;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    @Override
    public String displayName(DisplayNameVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(CASCO_DRIVER.displayName(variant, locale));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	Optional.ofNullable(personalData) //
		.map(PersonalData::getFullName) //
		.ifPresent(sj::add);

	MyStrings.optionalString(idNumber) //
		.map(FIELD_ID_NUMBER.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.append(appendEntityId()) //
		.toString();
    }

}
