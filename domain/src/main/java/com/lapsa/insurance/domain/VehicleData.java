package com.lapsa.insurance.domain;

import com.lapsa.cars.validators.ValidVINCode;
import com.lapsa.insurance.validation.NotEmptyString;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.insurance.validation.ValidVehicleYearOfIssue;

public class VehicleData extends BaseEntity<Integer> {

    @NotNullValue
    @ValidVINCode(checkDigit = false)
    private String vinCode;

    @NotNullValue
    @NotEmptyString
    private String model;

    @NotNullValue
    @NotEmptyString
    private String manufacturer;

    @NotNullValue
    @NotEmptyString
    private String color;

    @ValidVehicleYearOfIssue
    private int yearOfIssue;

    private VehicleCertificateData certificateData = new VehicleCertificateData();

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

    public int getYearOfIssue() {
	return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
	this.yearOfIssue = yearOfIssue;
    }

    public VehicleCertificateData getCertificateData() {
	return certificateData;
    }

    public void setCertificateData(VehicleCertificateData certificateData) {
	this.certificateData = certificateData;
    }
}
