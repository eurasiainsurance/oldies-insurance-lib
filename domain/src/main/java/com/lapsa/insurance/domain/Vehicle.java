package com.lapsa.insurance.domain;

import com.lapsa.cars.validators.ValidVINCode;
import com.lapsa.insurance.validation.ValidVehicleYearOfIssue;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;
import com.lapsa.kz.country.validators.ValidKZArea;
import com.lapsa.kz.country.validators.ValidKZCity;
import com.lapsa.validation.NotEmptyString;
import com.lapsa.validation.NotNullValue;

public abstract class Vehicle extends BaseEntity<Integer> {
    private static final long serialVersionUID = -7589698813986815583L;

    @NotNullValue
    @ValidVINCode(checkDigit = false)
    protected String vinCode;

    @NotNullValue
    @NotEmptyString
    protected String model;

    @NotNullValue
    @NotEmptyString
    protected String manufacturer;

    @NotNullValue
    @NotEmptyString
    protected String color;

    @ValidVehicleYearOfIssue
    protected Integer yearOfManufacture;

    @NotNullValue
    @ValidKZArea
    protected KZArea area;

    @NotNullValue
    @ValidKZCity
    protected KZCity city;

    protected VehicleCertificateData certificateData = new VehicleCertificateData();

    public String getDisplayName() {
	return (((manufacturer == null || manufacturer.isEmpty()) ? "" : (manufacturer + " "))
		+ ((model == null || model.isEmpty()) ? "" : (model + " "))).trim();
    }

    // GENERATED

    public String getVinCode() {
	return vinCode;
    }

    public void setVinCode(String vinCode) {
	this.vinCode = vinCode;
    }

    public String getModel() {
	return model;
    }

    public void setModel(String model) {
	this.model = model;
    }

    public String getManufacturer() {
	return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
    }

    public String getColor() {
	return color;
    }

    public void setColor(String color) {
	this.color = color;
    }

    public Integer getYearOfManufacture() {
	return yearOfManufacture;
    }

    public void setYearOfManufacture(Integer yearOfManufacture) {
	this.yearOfManufacture = yearOfManufacture;
    }

    public KZArea getArea() {
	return area;
    }

    public void setArea(KZArea area) {
	this.area = area;
    }

    public KZCity getCity() {
	return city;
    }

    public void setCity(KZCity city) {
	this.city = city;
    }

    public VehicleCertificateData getCertificateData() {
	return certificateData;
    }

    public void setCertificateData(VehicleCertificateData certificateData) {
	this.certificateData = certificateData;
    }
}
