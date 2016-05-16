package com.lapsa.insurance.persistence.entities;

import java.util.List;

import com.lapsa.insurance.domain.CalculationData;
import com.lapsa.insurance.domain.InsuredDriverData;
import com.lapsa.insurance.domain.InsuredVehicleData;
import com.lapsa.insurance.domain.PloicyRequesterData;
import com.lapsa.insurance.domain.PolicyObtainingData;

public class PolicyExpressOrder {

    private int id;
    private List<InsuredDriverData> drivers;
    private List<InsuredVehicleData> vehicles;
    private CalculationData calculationData;
    private PloicyRequesterData requesterData;
    private PolicyObtainingData obtaininigData;

    // GENERATED

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public List<InsuredDriverData> getDrivers() {
	return drivers;
    }

    public void setDrivers(List<InsuredDriverData> drivers) {
	this.drivers = drivers;
    }

    public List<InsuredVehicleData> getVehicles() {
	return vehicles;
    }

    public void setVehicles(List<InsuredVehicleData> vehicles) {
	this.vehicles = vehicles;
    }

    public CalculationData getCalculationData() {
	return calculationData;
    }

    public void setCalculationData(CalculationData calculationData) {
	this.calculationData = calculationData;
    }

    public PloicyRequesterData getRequesterData() {
	return requesterData;
    }

    public void setRequesterData(PloicyRequesterData requesterData) {
	this.requesterData = requesterData;
    }

    public PolicyObtainingData getObtaininigData() {
	return obtaininigData;
    }

    public void setObtaininigData(PolicyObtainingData obtaininigData) {
	this.obtaininigData = obtaininigData;
    }
}
