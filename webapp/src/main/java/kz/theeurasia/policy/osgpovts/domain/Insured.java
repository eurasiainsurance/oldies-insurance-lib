package kz.theeurasia.policy.osgpovts.domain;

import java.util.UUID;

import kz.theeurasia.services.domain.esbd.ClientInfo;
import kz.theeurasia.services.domain.global.InsuranceClassType;
import kz.theeurasia.services.domain.osgpovts.DriverExpirienceClass;
import kz.theeurasia.services.domain.osgpovts.InsuredAgeClass;

public class Insured {
    private UUID id;

    private InsuredAgeClass insuredAgeClass;
    private DriverExpirienceClass driverExpirienceClass;
    private String idNumber;
    private boolean hasPrivilege;
    private InsuranceClassType insuranceClassType;
    private ClientInfo clientInfo;

    public Insured() {
	id = UUID.randomUUID();
    }

    public Insured(InsuredAgeClass insuredAgeClass, DriverExpirienceClass driverExpirienceClass, String idNumber,
	    boolean hasPrivilege, ClientInfo clientInfo, InsuranceClassType insuranceClassType) {
	this();
	this.insuredAgeClass = insuredAgeClass;
	this.driverExpirienceClass = driverExpirienceClass;
	this.idNumber = idNumber;
	this.hasPrivilege = hasPrivilege;
	this.insuranceClassType = insuranceClassType;
    }

    public UUID getId() {
	return id;
    }

    public InsuredAgeClass getInsuredAgeClass() {
	return insuredAgeClass;
    }

    public void setInsuredAgeClass(InsuredAgeClass insuredAgeClass) {
	this.insuredAgeClass = insuredAgeClass;
    }

    public DriverExpirienceClass getDriverExpirienceClass() {
	return driverExpirienceClass;
    }

    public void setDriverExpirienceClass(DriverExpirienceClass driverExpirienceClass) {
	this.driverExpirienceClass = driverExpirienceClass;
    }

    public String getIdNumber() {
	return idNumber;
    }

    public void setIdNumber(String idNumber) {
	this.idNumber = idNumber;
    }

    public boolean isHasPrivilege() {
	return hasPrivilege;
    }

    public void setHasPrivilege(boolean hasPrivilege) {
	this.hasPrivilege = hasPrivilege;
    }

    public InsuranceClassType getInsuranceClassType() {
	return insuranceClassType;
    }

    public void setInsuranceClassType(InsuranceClassType insuranceClassType) {
	this.insuranceClassType = insuranceClassType;
    }

    public ClientInfo getClientInfo() {
	return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
	this.clientInfo = clientInfo;
    }

    @Override
    public int hashCode() {
	return this.getClass().hashCode() * id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	return obj != null && obj instanceof Insured && getId().equals(((Insured) obj).getId());
    }
}
