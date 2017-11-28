package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;
import static com.lapsa.international.phone.CountryCode.*;

import java.util.Locale;
import java.util.StringJoiner;

import javax.validation.constraints.AssertTrue;

import com.lapsa.international.localization.LocalizationLanguage;
import com.lapsa.international.phone.PhoneNumber;
import com.lapsa.international.phone.validators.ValidPhoneNumber;

import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.javax.validation.NotNullValue;
import tech.lapsa.javax.validation.ValidEmail;
import tech.lapsa.javax.validation.ValidHumanName;
import tech.lapsa.kz.taxpayer.TaxpayerNumber;
import tech.lapsa.kz.taxpayer.validators.ValidTaxpayerNumber;
import tech.lapsa.patterns.domain.Domain;
import tech.lapsa.patterns.domain.HashCodePrime;

@HashCodePrime(73)
public class RequesterData extends Domain {

    private static final long serialVersionUID = 1L;

    @ValidHumanName
    private String name;

    @ValidEmail
    private String email;

    @ValidTaxpayerNumber
    private TaxpayerNumber idNumber;

    @NotNullValue
    @ValidPhoneNumber(countriesRequired = { KZ, RU, GE, BY, BY, CN, KG, UZ, UA })
    private PhoneNumber phone;

    private boolean allowSpam;

    @AssertTrue(message = "{com.lapsa.insurance.domain.RequesterData.allowProcessPersonalData.AssertTrue.message}")
    private boolean allowProcessPersonalData;

    private LocalizationLanguage preferLanguage;

    @Override
    public String localized(LocalizationVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(REQUESTER_DATA.localized(variant, locale));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	MyOptionals.of(name) //
		.ifPresent(sj::add);

	MyOptionals.of(idNumber) //
		.map(TaxpayerNumber::getNumber) //
		.map(FIELD_ID_NUMBER.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	MyOptionals.of(email) //
		.map(FIELD_EMAIL.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	MyOptionals.of(phone) //
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

    public TaxpayerNumber getIdNumber() {
	return idNumber;
    }

    public void setIdNumber(TaxpayerNumber idNumber) {
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
