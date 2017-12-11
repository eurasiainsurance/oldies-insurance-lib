package com.lapsa.insurance.domain;

import java.util.StringJoiner;

import com.lapsa.insurance.validation.ValidVehicleYearOfIssue;
import com.lapsa.international.cars.validators.ValidVINCode;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;
import com.lapsa.kz.country.validators.ValidKZArea;
import com.lapsa.kz.country.validators.ValidKZCity;

import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.javax.validation.NotEmptyString;
import tech.lapsa.javax.validation.NotNullValue;

public abstract class Vehicle extends BaseEntity<Integer> {

    private static final long serialVersionUID = 1L;

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

    @Override
    public void unlazy() {
	super.unlazy();
	MyOptionals.of(getCertificateData()).ifPresent(Domain::unlazy);
    }

    public String getFullName() {
	StringJoiner sj = new StringJoiner(" ");

	MyOptionals.of(manufacturer) //
		.map(String::trim) //
		.ifPresent(sj::add);

	MyOptionals.of(manufacturer) //
		.map(x -> model) // model used only in conjuction with first
				 // manufacturer
		.map(String::trim) //
		.ifPresent(sj::add);

	return MyStrings.nullOnEmpty(sj.toString());
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
