package com.lapsa.insurance.domain.casco;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.lapsa.commons.elements.Localized;
import com.lapsa.commons.function.MyStrings;
import com.lapsa.donkeyfaces.model.Image;
import com.lapsa.donkeyfaces.validators.FileSizeMeasure;
import com.lapsa.donkeyfaces.validators.MaxImageFileSize;
import com.lapsa.fin.FinCurrency;
import com.lapsa.insurance.domain.Vehicle;
import com.lapsa.insurance.elements.CascoCarAgeClass;
import com.lapsa.validation.NotNullValue;
import com.lapsa.validation.NotTooOldYearOfIssue;
import com.lapsa.validation.NotTooYoungYearOfIssue;

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

    // @NotNullValue
    @MaxImageFileSize(measure = FileSizeMeasure.MB, value = 10)
    private Image view1;

    // @NotNullValue
    @MaxImageFileSize(measure = FileSizeMeasure.MB, value = 10)
    private Image view2;

    // @NotNullValue
    @MaxImageFileSize(measure = FileSizeMeasure.MB, value = 10)
    private Image view3;

    // @NotNullValue
    @MaxImageFileSize(measure = FileSizeMeasure.MB, value = 10)
    private Image view4;

    @Override
    public String displayName(DisplayNameVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(MyStrings.optionalString(getFullName()) //
		.orElseGet(() -> CASCO_VEHICLE.displayName(variant, locale)));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	Optional.ofNullable(cost)
		.map(x -> FinCurrency.KZT.formatAmount(x))
		.map(CASCO_VEHICLE_COST.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	Optional.ofNullable(carAgeClass) //
		.map(Localized.toDisplayNameMapper(variant, locale)) //
		.map(CASCO_VEHICLE_AGE_CLASS.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.append(appendEntityId()) //
		.toString();
    }

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

    public Image getView1() {
	return view1;
    }

    public void setView1(Image view1) {
	this.view1 = view1;
    }

    public Image getView2() {
	return view2;
    }

    public void setView2(Image view2) {
	this.view2 = view2;
    }

    public Image getView3() {
	return view3;
    }

    public void setView3(Image view3) {
	this.view3 = view3;
    }

    public Image getView4() {
	return view4;
    }

    public void setView4(Image view4) {
	this.view4 = view4;
    }
}
