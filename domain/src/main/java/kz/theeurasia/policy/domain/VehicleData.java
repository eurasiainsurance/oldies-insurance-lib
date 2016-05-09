package kz.theeurasia.policy.domain;

import com.lapsa.cars.validators.ValidVINCode;

import kz.theeurasia.policy.validator.NotEmptyString;
import kz.theeurasia.policy.validator.NotNullValue;
import kz.theeurasia.policy.validator.ValidVehicleYearOfIssue;

public class VehicleData {

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
