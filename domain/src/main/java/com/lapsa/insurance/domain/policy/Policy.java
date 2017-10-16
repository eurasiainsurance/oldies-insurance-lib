package com.lapsa.insurance.domain.policy;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringJoiner;
import java.util.stream.Stream;

import com.lapsa.insurance.domain.InsuranceProduct;

import tech.lapsa.java.commons.function.MyNumbers;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyOptionals;

public class Policy extends InsuranceProduct {
    private static final long serialVersionUID = 1148321211581313286L;
    private static final int PRIME = 79;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private List<PolicyDriver> insuredDrivers = new ArrayList<>();
    private List<PolicyVehicle> insuredVehicles = new ArrayList<>();

    public PolicyDriver addDriver(PolicyDriver driver) {
	MyObjects.requireNonNull(driver, "Value must not be null");
	if (insuredDrivers == null)
	    insuredDrivers = new ArrayList<>();
	insuredDrivers.add(driver);
	return driver;
    }

    public PolicyDriver removeDriver(PolicyDriver driver) {
	MyObjects.requireNonNull(driver, "Value must not be null");
	if (insuredDrivers != null)
	    insuredDrivers.remove(driver);
	return driver;
    }

    public PolicyVehicle addVehicle(PolicyVehicle vehicle) {
	MyObjects.requireNonNull(vehicle, "Value must not be null");
	if (insuredVehicles == null)
	    insuredVehicles = new ArrayList<>();
	insuredVehicles.add(vehicle);
	return vehicle;
    }

    public PolicyVehicle removeVehicle(PolicyVehicle vehicle) {
	MyObjects.requireNonNull(vehicle, "Value must not be null");
	if (insuredVehicles != null)
	    insuredVehicles.remove(vehicle);
	return vehicle;
    }

    @Override
    public String localized(LocalizationVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(POLICY.localized(variant, locale));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	MyOptionals.of(calculation) //
		.filter(x -> MyNumbers.nonZero(x.getPremiumCost())) //
		.filter(x -> MyObjects.nonNull(x.getPremiumCurrency()))
		.map(x -> x.getPremiumCurrency().formatAmount(x.getPremiumCost())) //
		.map(POLICY_COST.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.streamOf(insuredDrivers) //
		.map(Stream::count)
		.map(String::valueOf)
		.map(POLICY_DRIVERS_COUNT.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.streamOf(insuredVehicles) //
		.map(Stream::count)
		.map(String::valueOf)
		.map(POLICY_VEHICLES_COUNT.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.append(appendEntityId()) //
		.toString();
    }

    // GENERATED

    public List<PolicyDriver> getInsuredDrivers() {
	return insuredDrivers;
    }

    protected void setInsuredDrivers(List<PolicyDriver> insuredDrivers) {
	this.insuredDrivers = insuredDrivers;
    }

    public List<PolicyVehicle> getInsuredVehicles() {
	return insuredVehicles;
    }

    protected void setInsuredVehicles(List<PolicyVehicle> insuredVehicles) {
	this.insuredVehicles = insuredVehicles;
    }
}