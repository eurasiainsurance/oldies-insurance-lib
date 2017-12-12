package com.lapsa.insurance.domain.policy;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringJoiner;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lapsa.insurance.domain.BaseEntity;
import com.lapsa.insurance.domain.InsuranceProduct;

import tech.lapsa.java.commons.function.MyNumbers;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.patterns.domain.HashCodePrime;

@Entity
@Table(name = "POLICY")
@HashCodePrime(79)
public class Policy extends InsuranceProduct {

    private static final long serialVersionUID = 1L;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "POLICY_ID")
    private List<PolicyDriver> insuredDrivers = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "POLICY_ID")
    private List<PolicyVehicle> insuredVehicles = new ArrayList<>();

    @Override
    public void unlazy() {
	super.unlazy();
	MyOptionals.streamOf(getInsuredDrivers()) //
		.orElseGet(Stream::empty) //
		.filter(MyObjects::nonNull) //
		.forEach(BaseEntity::unlazy);
	MyOptionals.streamOf(getInsuredVehicles()) //
		.orElseGet(Stream::empty) //
		.filter(MyObjects::nonNull) //
		.forEach(BaseEntity::unlazy);
    }

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