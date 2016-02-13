package kz.theeurasia.policy.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PolicyRequestData {
    private final UUID id = UUID.randomUUID();

    private InsurantData insurant = new InsurantData();
    private List<InsuredDriverData> insuredDrivers = new ArrayList<>();
    private List<InsuredVehicleData> insuredVehicles = new ArrayList<>();
    private PolicyTermClass termClass = PolicyTermClass.YEAR;
    private double calculatedPremiumCost;

    @Override
    public int hashCode() {
	return this.getClass().hashCode() * id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	return obj != null && this.getClass().isInstance(obj) && getId().equals((this.getClass().cast(obj)).getId());
    }

    public String getSafeId() {
	return id.toString().replaceAll("-", "_");
    }

    // GENERATED

    public UUID getId() {
	return id;
    }

    public InsurantData getInsurant() {
	return insurant;
    }

    public void setInsurant(InsurantData insurant) {
	this.insurant = insurant;
    }

    public List<InsuredDriverData> getInsuredDrivers() {
	return insuredDrivers;
    }

    public void setInsuredDrivers(List<InsuredDriverData> insuredDrivers) {
	this.insuredDrivers = insuredDrivers;
    }

    public List<InsuredVehicleData> getInsuredVehicles() {
	return insuredVehicles;
    }

    public void setInsuredVehicles(List<InsuredVehicleData> insuredVehicles) {
	this.insuredVehicles = insuredVehicles;
    }

    public PolicyTermClass getTermClass() {
	return termClass;
    }

    public void setTermClass(PolicyTermClass termClass) {
	this.termClass = termClass;
    }

    public double getCalculatedPremiumCost() {
	return calculatedPremiumCost;
    }

    public void setCalculatedPremiumCost(double calculatedPremiumCost) {
	this.calculatedPremiumCost = calculatedPremiumCost;
    }
}
