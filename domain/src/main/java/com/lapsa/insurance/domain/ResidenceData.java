package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.Locale;
import java.util.StringJoiner;

import com.lapsa.commons.elements.Localized;
import com.lapsa.commons.function.MyOptionals;
import com.lapsa.kz.country.KZCity;
import com.lapsa.kz.country.validators.ValidKZCity;
import com.lapsa.validation.NotEmptyString;
import com.lapsa.validation.NotNullValue;

public class ResidenceData extends BaseDomain {
    private static final long serialVersionUID = 6787004222278561370L;
    private static final int PRIME = 103;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private Boolean resident;

    @NotNullValue
    @ValidKZCity
    private KZCity city;

    @NotNullValue
    @NotEmptyString
    private String address;

    @Override
    public String displayName(DisplayNameVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(RESIDENCE_DATA.displayName(variant, locale));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	MyOptionals.of(city) //
		.map(Localized.toDisplayNameMapper(variant, locale)) //
		.map(RESIDENCE_DATA_CITY.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(address)
		.map(RESIDENCE_DATA_ADDRESS.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(resident)
		.map(x -> x.booleanValue() ? RESIDENCE_DATA_RESIDENT : RESIDENCE_DATA_NONRESIDENT)
		.map(Localized.toDisplayNameMapper(variant, locale))
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.toString();
    }

    // GENERATED

    public Boolean isResident() {
	return resident;
    }

    public void setResident(Boolean resident) {
	this.resident = resident;
    }

    public KZCity getCity() {
	return city;
    }

    public void setCity(KZCity city) {
	this.city = city;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }
}
