package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;

import com.lapsa.commons.function.MyStrings;
import com.lapsa.international.internet.validators.ValidEmail;
import com.lapsa.international.internet.validators.ValidURL;
import com.lapsa.international.phone.PhoneNumber;
import com.lapsa.international.phone.validators.ValidPhoneNumber;
import com.lapsa.validation.NotNullValue;

public class ContactData extends BaseDomain {
    private static final long serialVersionUID = 6954755236615159684L;
    private static final int PRIME = 13;
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
    @ValidPhoneNumber
    private PhoneNumber phone;

    @NotNullValue
    @ValidEmail
    private String email;

    @ValidURL
    private String siteUrl;

    @Override
    public String displayName(DisplayNameVariant variant, Locale locale) {
	StringJoiner sj = new StringJoiner(", ", CONTACT_DATA.displayName(variant, locale) + " ", "");
	sj.setEmptyValue(CONTACT_DATA_EMPTY.displayName(variant, locale));

	Optional.ofNullable(email) //
		.filter(MyStrings::nonEmptyString) //
		.ifPresent(sj::add);

	Optional.ofNullable(phone) //
		.map(PhoneNumber::getFormatted) //
		.ifPresent(sj::add);

	Optional.ofNullable(siteUrl) //
		.filter(MyStrings::nonEmptyString) //
		.ifPresent(sj::add);

	return sj.toString();
    }

    public static void main(String[] args) {
	ContactData cd = new ContactData();
	// cd.setEmail("vadim.o.isaev@gmail.com");
	// cd.setPhone(PhoneNumber.of(CountryCode.AE, "701", "9377979"));
	System.out.println(cd);
    }

    // GENERATED

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

    public String getSiteUrl() {
	return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
	this.siteUrl = siteUrl;
    }

}
