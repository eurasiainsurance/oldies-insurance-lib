package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;

import com.lapsa.commons.function.MyStrings;

public class CompanyContactEmail extends BaseEntity<Integer> {
    private static final long serialVersionUID = 4127152799405864110L;
    private static final int PRIME = 5;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private String address;

    @Override
    public String displayName(DisplayNameVariant variant, Locale locale) {
	final StringJoiner sj = new StringJoiner(" ", COMPANY_CONTACT_EMAIL.displayName(variant, locale) + " ", "");

	sj.add(Optional.ofNullable(address) //
		.filter(MyStrings::nonEmptyString) //
		.orElse("<" + COMPANY_CONTACT_EMAIL_EMPTY.displayName(variant, locale) + ">"));

	return sj.toString() + appendEntityId();
    }

    // GENERATED

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }
}
