package kz.theeurasia.policy.domain;

import java.util.Locale;

import kz.theeurasia.policy.validator.NotEmptyString;
import kz.theeurasia.policy.validator.NotNullValue;
import kz.theeurasia.policy.validator.ValidVINCode;
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

    public String getDisplayName() {
	return (((manufacturer == null || manufacturer.isEmpty()) ? ""
		: (manufacturer + " ")) +
		((model == null || model.isEmpty()) ? ""
			: (model + " "))).trim();
    }

    public void setVinCode(String vinCode) {
	this.vinCode = vinCode;
	if (this.vinCode != null)
	    this.vinCode = this.vinCode.toUpperCase(Locale.ENGLISH);
    }

    // GENERATED

    public String getVinCode() {
	return vinCode;
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

}
