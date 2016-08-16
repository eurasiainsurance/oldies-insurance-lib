package com.lapsa.insurance.domain.casco;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.lapsa.insurance.domain.Vehicle;
import com.lapsa.insurance.elements.CascoCarAgeClass;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.insurance.validation.NotTooOldYearOfIssue;
import com.lapsa.insurance.validation.NotTooYoungYearOfIssue;

public class CascoVehicle extends Vehicle {
    private static final long serialVersionUID = 2602178314016175969L;
    private static final int PRIME = 157;
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
    @Min(message = "{com.lapsa.insurance.domain.casco.CascoVehicle.cost.Min.message}", value = 1000000)
    @Max(message = "{com.lapsa.insurance.domain.casco.CascoVehicle.cost.Max.message}", value = 52500000)
    private Double cost;

    @NotNullValue
    private CascoCarAgeClass carAgeClass;

    // GENERATED

    public Double getCost() {
	return cost;
    }

    public void setCost(Double cost) {
	this.cost = cost;
    }

    @NotNullValue
    @NotTooOldYearOfIssue(message = "{com.lapsa.insurance.domain.casco.CascoVehicle.yearOfManufacture.NotTooOldYearOfIssue.message}", maxAge = 10)
    @NotTooYoungYearOfIssue(message = "{com.lapsa.insurance.domain.casco.CascoVehicle.yearOfManufacture.NotTooYoungYearOfIssue.message}", minAge = 0)
    @Override
    public Integer getYearOfManufacture() {
	return super.getYearOfManufacture();
    }

    public CascoCarAgeClass getCarAgeClass() {
	return carAgeClass;
    }

    public void setCarAgeClass(CascoCarAgeClass carAgeClass) {
	this.carAgeClass = carAgeClass;
    }
}
