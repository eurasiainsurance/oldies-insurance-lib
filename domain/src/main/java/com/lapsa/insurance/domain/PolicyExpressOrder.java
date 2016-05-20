package com.lapsa.insurance.domain;

import java.util.Date;
import java.util.List;

import com.lapsa.insurance.crm.ClosingResult;
import com.lapsa.insurance.crm.RequestStatus;

public class PolicyExpressOrder extends BaseDomain<Integer> {

    private Date created;
    private Date updated;
    private Date closed;
    private RequestStatus requestStatus;
    private ClosingResult closingResult;

    private List<InsuredDriverData> drivers;
    private List<InsuredVehicleData> vehicles;
    private CalculationData calculationData;
    private PloicyRequesterData requesterData;
    private PolicyObtainingData obtaininigData;

    // GENERATED

    public Date getCreated() {
	return created;
    }

    public void setCreated(Date created) {
	this.created = created;
    }

    public Date getUpdated() {
	return updated;
    }

    public void setUpdated(Date updated) {
	this.updated = updated;
    }

    public Date getClosed() {
	return closed;
    }

    public void setClosed(Date closed) {
	this.closed = closed;
    }

    public RequestStatus getRequestStatus() {
	return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
	this.requestStatus = requestStatus;
    }

    public ClosingResult getClosingResult() {
	return closingResult;
    }

    public void setClosingResult(ClosingResult closingResult) {
	this.closingResult = closingResult;
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
