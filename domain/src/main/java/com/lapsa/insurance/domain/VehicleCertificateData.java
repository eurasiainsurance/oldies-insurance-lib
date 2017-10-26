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
import tech.lapsa.kz.vehicle.VehicleRegNumber;
import tech.lapsa.kz.vehicle.validators.ValidVehicleRegNumber;

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
    @ValidVehicleRegNumber
    private VehicleRegNumber registrationNumber;

    @NotNullValue
    @NotEmptyString
    private String number;

    @NotNullValue
    @ValidDateOfIssue
    private LocalDate dateOfIssue;

    @Override
    public String localized(LocalizationVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(VEHICLE_CERTIFICATE_DATA.localized(variant, locale));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	MyOptionals.of(number)
		.map(FIELD_NUMBER.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	MyOptionals.of(dateOfIssue) //
		.map(Localizeds.localDateMapper(locale))//
		.map(VEHICLE_CERTIFICATE_DATA_ISSUED.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	MyOptionals.of(registrationNumber)
		.map(VehicleRegNumber::getNumber) //
		.map(VEHICLE_CERTIFICATE_DATA_REGNUMBER.fieldAsCaptionMapper(variant, locale)) //
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

    public VehicleRegNumber getRegistrationNumber() {
	return registrationNumber;
    }

    public void setRegistrationNumber(VehicleRegNumber registrationNumber) {
	this.registrationNumber = registrationNumber;
    }
}
