package com.lapsa.insurance.domain;

import java.util.Map;

import com.lapsa.insurance.validation.NotEmptyString;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.kz.country.KZCity;
import com.lapsa.kz.country.validators.ValidKZCity;
import com.lapsa.localization.LocalizationLanguage;

public class PostAddress extends BaseDomain {
    private static final long serialVersionUID = -5557010401647487544L;

    @NotNullValue
    @NotEmptyString
    private String postIndex;

    @NotNullValue
    @ValidKZCity(invalidValues = KZCity.OTHER)
    private KZCity city;

    @NotNullValue
    @NotEmptyString
    private String street;

    private Map<LocalizationLanguage, String> streetLocalization;

    public String getPostIndex() {
	return postIndex;
    }

    public void setPostIndex(String postIndex) {
	this.postIndex = postIndex;
    }

    public KZCity getCity() {
	return city;
    }

    public void setCity(KZCity city) {
	this.city = city;
    }

    public String getStreet() {
	return street;
    }

    public void setStreet(String street) {
	this.street = street;
    }

    public Map<LocalizationLanguage, String> getStreetLocalization() {
	return streetLocalization;
    }

    public void setStreetLocalization(Map<LocalizationLanguage, String> streetLocalization) {
	this.streetLocalization = streetLocalization;
    }
}
