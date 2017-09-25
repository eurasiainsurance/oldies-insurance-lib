package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;

import com.lapsa.commons.function.MyStrings;
import com.lapsa.validation.NotEmptyString;
import com.lapsa.validation.NotNullValue;
import com.lapsa.validation.ValidDateOfIssue;

public class DriverLicenseData extends SidedScannedDocument {
    private static final long serialVersionUID = -4979156573374546371L;
    private static final int PRIME = 17;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    @NotNullValue
    @NotEmptyString
    private String number;

    @NotNullValue
    @ValidDateOfIssue
    private LocalDate dateOfIssue;

    @Override
    public String displayName(DisplayNameVariant variant, Locale locale) {
	StringJoiner sj = new StringJoiner(" ", DRIVER_LICENSE_DATA.displayName(variant, locale) + " ", "");

	sj.add(DRIVER_LICENSE_DATA.displayName(variant, locale));

	Optional.ofNullable(number)
		.filter(MyStrings::nonEmptyString)
		.map(x -> DRIVER_LICENSE_DATA_NUMBER.displayName(variant, locale) + " " + x)
		.ifPresent(sj::add);

	Optional.ofNullable(dateOfIssue) //
		.map(DateTimeFormatter.ISO_LOCAL_DATE::format)
		.map(x -> DRIVER_LICENSE_DATA_ISSUED.displayName(variant, locale) + " " + x)
		.ifPresent(sj::add);

	return sj.toString() + " " + appendEntityId();
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
