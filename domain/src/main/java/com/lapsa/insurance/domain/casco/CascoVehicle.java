package com.lapsa.insurance.domain.casco;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.lapsa.insurance.domain.BaseEntity;
import com.lapsa.insurance.elements.CascoCarAgeClass;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.insurance.validation.NotTooOldYearOfIssue;
import com.lapsa.insurance.validation.NotTooYoungYearOfIssue;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;
import com.lapsa.kz.country.validators.ValidKZArea;
import com.lapsa.kz.country.validators.ValidKZCity;

public class CascoVehicle extends BaseEntity<Integer> {
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
    @NotTooOldYearOfIssue(message = "{com.lapsa.insurance.domain.casco.CascoVehicle.yearOfIssue.NotTooOldYearOfIssue.message}", maxAge = 10)
    @NotTooYoungYearOfIssue(message = "{com.lapsa.insurance.domain.casco.CascoVehicle.yearOfIssue.NotTooYoungYearOfIssue.message}", minAge = 0)
    private Integer yearOfIssue;

    @NotNullValue
    private CascoCarAgeClass carAgeClass;

    @NotNullValue
    @ValidKZArea
    private KZArea area;

    @NotNullValue
    @ValidKZCity
    private KZCity city;

    // GENERATED

    public Double getCost() {
	return cost;
    }

    public void setCost(Double cost) {
	this.cost = cost;
    }

    public Integer getYearOfIssue() {
	return yearOfIssue;
    }

    public void setYearOfIssue(Integer yearOfIssue) {
	this.yearOfIssue = yearOfIssue;
    }

    public CascoCarAgeClass getCarAgeClass() {
	return carAgeClass;
    }

    public void setCarAgeClass(CascoCarAgeClass carAgeClass) {
	this.carAgeClass = carAgeClass;
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

}
