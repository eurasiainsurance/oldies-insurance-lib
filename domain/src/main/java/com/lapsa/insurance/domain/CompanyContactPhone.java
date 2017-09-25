package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;

import com.lapsa.international.phone.PhoneNumber;
import com.lapsa.international.phone.PhoneType;

public class CompanyContactPhone extends BaseEntity<Integer> {
    private static final long serialVersionUID = -1005845698858843018L;
    private static final int PRIME = 7;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private PhoneNumber phone;
    private PhoneType phoneType;

    @Override
    public String displayName(DisplayNameVariant variant, Locale locale) {
	final StringJoiner sj = new StringJoiner(" ", COMPANY_CONTACT_PHONE.displayName(variant, locale) + " ", "");

	sj.add("<" + Optional.ofNullable(phone) //
		.map(PhoneNumber::getFormatted) //
		.orElse(COMPANY_CONTACT_PHONE_EMPTY.displayName(variant, locale)) + ">");

	Optional.ofNullable(phoneType) //
		.map(x -> "(" + x.displayName(variant, locale) + ")") //
		.ifPresent(sj::add);

	return appendEntityId(sj).toString();
    }

    // GENERATED

    public PhoneNumber getPhone() {
	return phone;
    }

    public void setPhone(PhoneNumber phone) {
	this.phone = phone;
    }

    public PhoneType getPhoneType() {
	return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
	this.phoneType = phoneType;
    }
}
