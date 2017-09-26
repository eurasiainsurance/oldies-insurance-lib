package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;
import static com.lapsa.international.phone.CountryCode.*;

import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;

import javax.validation.constraints.AssertTrue;

import com.lapsa.commons.function.MyStrings;
import com.lapsa.international.internet.validators.ValidEmail;
import com.lapsa.international.localization.LocalizationLanguage;
import com.lapsa.international.phone.PhoneNumber;
import com.lapsa.international.phone.validators.ValidPhoneNumber;
import com.lapsa.kz.idnumber.validators.ValidIdNumber;
import com.lapsa.validation.NotNullValue;
import com.lapsa.validation.ValidHumanName;

public class RequesterData extends BaseDomain {
    private static final long serialVersionUID = 2536050924805456436L;
    private static final int PRIME = 73;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    @ValidHumanName
    private String name;

    @ValidEmail
    private String email;

    @ValidIdNumber
    private String idNumber;

    @NotNullValue
    @ValidPhoneNumber(countriesRequired = { KZ, RU, GE, BY, BY, CN, KG, UZ, UA })
    private PhoneNumber phone;

    private boolean allowSpam;

    @AssertTrue(message = "{com.lapsa.insurance.domain.RequesterData.allowProcessPersonalData.AssertTrue.message}")
    private boolean allowProcessPersonalData;

    private LocalizationLanguage preferLanguage;

    @Override
    public String displayName(DisplayNameVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(REQUESTER_DATA.displayName(variant, locale));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	MyStrings.optionalString(name) //
		.ifPresent(sj::add);

	MyStrings.optionalString(idNumber) //
		.map(FIELD_ID_NUMBER.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	MyStrings.optionalString(email) //
		.map(FIELD_EMAIL.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	Optional.ofNullable(phone) //
		.map(PhoneNumber::getFormatted) //
		.map(FIELD_PHONE.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.toString();
    }

    // GENERATED

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public PhoneNumber getPhone() {
	return phone;
    }

    public void setPhone(PhoneNumber phone) {
	this.phone = phone;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getIdNumber() {
	return idNumber;
    }

    public void setIdNumber(String idNumber) {
	this.idNumber = idNumber;
    }

    public LocalizationLanguage getPreferLanguage() {
	return preferLanguage;
    }

    public void setPreferLanguage(LocalizationLanguage preferLanguage) {
	this.preferLanguage = preferLanguage;
    }

    public boolean isAllowSpam() {
	return allowSpam;
    }

    public void setAllowSpam(boolean allowSpam) {
	this.allowSpam = allowSpam;
    }

    public boolean isAllowProcessPersonalData() {
	return allowProcessPersonalData;
    }

    public void setAllowProcessPersonalData(boolean allowProcessPersonalData) {
	this.allowProcessPersonalData = allowProcessPersonalData;
    }
}
