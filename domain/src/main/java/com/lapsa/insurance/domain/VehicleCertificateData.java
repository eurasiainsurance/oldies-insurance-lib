package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;

import com.lapsa.commons.function.MyStrings;
import com.lapsa.insurance.validation.ValidVehicleRegistrationNumber;
import com.lapsa.validation.NotEmptyString;
import com.lapsa.validation.NotNullValue;
import com.lapsa.validation.ValidDateOfIssue;

public class VehicleCertificateData extends SidedScannedDocument {
    private static final long serialVersionUID = -8205031496636707778L;
    private static final int PRIME = 109;
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
    @ValidVehicleRegistrationNumber
    private String registrationNumber;

    @NotNullValue
    @NotEmptyString
    private String number;

    @NotNullValue
    @ValidDateOfIssue
    private LocalDate dateOfIssue;

    @Override
    public String displayName(DisplayNameVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(VEHICLE_CERTIFICATE_DATA.displayName(variant, locale));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	Optional.ofNullable(number)
		.filter(MyStrings::nonEmptyString)
		.map(x -> FIELD_NUMBER.displayName(variant, locale) + " " + x)
		.ifPresent(sj::add);

	Optional.ofNullable(dateOfIssue) //
		.map(DateTimeFormatter.ISO_LOCAL_DATE::format)
		.map(x -> VEHICLE_CERTIFICATE_DATA_ISSUED.displayName(variant, locale) + " " + x)
		.ifPresent(sj::add);

	Optional.ofNullable(registrationNumber)
		.filter(MyStrings::nonEmptyString)
		.map(x -> VEHICLE_CERTIFICATE_DATA_REGNUMBER.displayName(variant, locale) + " " + x)
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

    public String getRegistrationNumber() {
	return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
	this.registrationNumber = registrationNumber;
    }
}
