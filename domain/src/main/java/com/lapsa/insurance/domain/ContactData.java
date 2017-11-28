package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.Locale;
import java.util.StringJoiner;

import com.lapsa.international.internet.validators.ValidEmail;
import com.lapsa.international.internet.validators.ValidURL;
import com.lapsa.international.phone.PhoneNumber;
import com.lapsa.international.phone.validators.ValidPhoneNumber;

import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.javax.validation.NotNullValue;
import tech.lapsa.patterns.domain.Domain;
import tech.lapsa.patterns.domain.HashCodePrime;

@HashCodePrime(13)
public class ContactData extends Domain {

    private static final long serialVersionUID = 1L;

    @NotNullValue
    @ValidPhoneNumber
    private PhoneNumber phone;

    @NotNullValue
    @ValidEmail
    private String email;

    @ValidURL
    private String siteUrl;

    @Override
    public String localized(LocalizationVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(CONTACT_DATA.localized(variant, locale));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	MyOptionals.of(email) //
		.ifPresent(sj::add);

	MyOptionals.of(phone) //
		.map(PhoneNumber::getFormatted) //
		.ifPresent(sj::add);

	MyOptionals.of(siteUrl) //
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.toString();
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
