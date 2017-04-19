package com.lapsa.insurance.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lapsa.localization.LocalizationLanguage;
import com.lapsa.validation.NotEmptyString;
import com.lapsa.validation.NotNullValue;

public class CompanyPointOfSale extends BaseEntity<Integer> {
    private static final long serialVersionUID = 2591037979593224479L;
    private static final int PRIME = 11;
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
    private String name;

    private Map<LocalizationLanguage, String> nameLocalization = new HashMap<>();

    private PostAddress address;

    private GeoPoint geoPoint;

    private boolean available;

    private boolean companyOwnOffice;

    private boolean pickupAvailable;

    private boolean deliveryServicesAvailable;

    private List<CompanyContactPhone> phones = new ArrayList<>();

    private List<CompanyContactEmail> emailAddresses = new ArrayList<>();

    public CompanyContactPhone addPhone(CompanyContactPhone phone) {
	if (phone == null)
	    throw new NullPointerException("Value must not be null");
	if (phones == null)
	    phones = new ArrayList<>();
	phones.add(phone);
	return phone;
    }

    public CompanyContactPhone removePhone(CompanyContactPhone phone) {
	if (phone == null)
	    throw new NullPointerException("Value must not be null");
	if (phones != null)
	    phones.remove(phone);
	return phone;
    }

    public CompanyContactEmail addEmailAddress(CompanyContactEmail phone) {
	if (phone == null)
	    throw new NullPointerException("Value must not be null");
	if (emailAddresses == null)
	    emailAddresses = new ArrayList<>();
	emailAddresses.add(phone);
	return phone;
    }

    public CompanyContactEmail removeEmailAddress(CompanyContactEmail phone) {
	if (phone == null)
	    throw new NullPointerException("Value must not be null");
	if (emailAddresses != null)
	    emailAddresses.remove(phone);
	return phone;
    }

    // GENERATED

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Map<LocalizationLanguage, String> getNameLocalization() {
	return nameLocalization;
    }

    public void setNameLocalization(Map<LocalizationLanguage, String> nameLocalization) {
	this.nameLocalization = nameLocalization;
    }

    public PostAddress getAddress() {
	return address;
    }

    public void setAddress(PostAddress address) {
	this.address = address;
    }

    public GeoPoint getGeoPoint() {
	return geoPoint;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
	this.geoPoint = geoPoint;
    }

    public List<CompanyContactEmail> getEmailAddresses() {
	return emailAddresses;
    }

    public void setEmailAddresses(List<CompanyContactEmail> emailAddresses) {
	this.emailAddresses = emailAddresses;
    }

    public boolean isAvailable() {
	return available;
    }

    public void setAvailable(boolean available) {
	this.available = available;
    }

    public List<CompanyContactPhone> getPhones() {
	return phones;
    }

    public void setPhones(List<CompanyContactPhone> phones) {
	this.phones = phones;
    }

    public boolean isCompanyOwnOffice() {
	return companyOwnOffice;
    }

    public void setCompanyOwnOffice(boolean companyOwnOffice) {
	this.companyOwnOffice = companyOwnOffice;
    }

    public boolean isPickupAvailable() {
	return pickupAvailable;
    }

    public void setPickupAvailable(boolean pickupAvailable) {
	this.pickupAvailable = pickupAvailable;
    }

    public boolean isDeliveryServicesAvailable() {
	return deliveryServicesAvailable;
    }

    public void setDeliveryServicesAvailable(boolean deliveryServicesAvailable) {
	this.deliveryServicesAvailable = deliveryServicesAvailable;
    }
}
