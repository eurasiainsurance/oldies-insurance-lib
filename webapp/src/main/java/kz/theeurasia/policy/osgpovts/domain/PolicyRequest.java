package kz.theeurasia.policy.osgpovts.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PolicyRequest {
    private final UUID id = UUID.randomUUID();

    private Insurant insurant = new Insurant();
    private List<InsuredDriver> insuredDrivers = new ArrayList<>();
    private List<InsuredVehicle> insuredVehicles = new ArrayList<>();
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

    // GENERATED

    public UUID getId() {
	return id;
    }

    public Insurant getInsurant() {
	return insurant;
    }

    public void setInsurant(Insurant insurant) {
	this.insurant = insurant;
    }

    public List<InsuredDriver> getInsuredDrivers() {
	return insuredDrivers;
    }

    public void setInsuredDrivers(List<InsuredDriver> insuredDrivers) {
	this.insuredDrivers = insuredDrivers;
    }

    public List<InsuredVehicle> getInsuredVehicles() {
	return insuredVehicles;
    }

    public void setInsuredVehicles(List<InsuredVehicle> insuredVehicles) {
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
