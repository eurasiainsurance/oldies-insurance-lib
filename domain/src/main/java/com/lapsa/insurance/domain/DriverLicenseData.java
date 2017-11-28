package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.time.LocalDate;
import java.util.Locale;
import java.util.StringJoiner;

import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.localization.Localizeds;
import tech.lapsa.javax.validation.NotEmptyString;
import tech.lapsa.javax.validation.NotNullValue;
import tech.lapsa.javax.validation.ValidDateOfIssue;
import tech.lapsa.patterns.domain.HashCodePrime;

@HashCodePrime(17)
public class DriverLicenseData extends SidedScannedDocument {
    private static final long serialVersionUID = -4979156573374546371L;

    @NotNullValue
    @NotEmptyString
    private String number;

    @NotNullValue
    @ValidDateOfIssue
    private LocalDate dateOfIssue;

    @Override
    public String localized(LocalizationVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(DRIVER_LICENSE_DATA.localized(variant, locale));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	MyOptionals.of(number) //
		.map(FIELD_NUMBER.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(dateOfIssue) //
		.map(Localizeds.localDateMapper(locale)) //
		.map(DRIVER_LICENSE_DATA_ISSUED.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.append(appendEntityId()) //
		.toString();
    }

    // GENERATED

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	this.number = number;
    }

    public LocalDate getDateOfIssue() {
	return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
	this.dateOfIssue = dateOfIssue;
    }
}
