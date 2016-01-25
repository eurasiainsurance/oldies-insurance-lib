package kz.theeurasia.police.osgpovts.domain;

import java.util.UUID;

import kz.theeurasia.services.domain.AgeClass;
import kz.theeurasia.services.domain.ClientInfo;
import kz.theeurasia.services.domain.DriverExpirienceClass;
import kz.theeurasia.services.domain.InsuranceClassType;

public class Insured {
    private UUID id;

    private AgeClass ageClass;
    private DriverExpirienceClass driverExpirienceClass;
    private String idNumber;
    private boolean hasPrivilege;
    private InsuranceClassType insuranceClassType;
    private ClientInfo clientInfo;

    public Insured() {
	id = UUID.randomUUID();
    }

    public Insured(AgeClass ageClass, DriverExpirienceClass driverExpirienceClass, String idNumber,
	    boolean hasPrivilege, ClientInfo clientInfo, InsuranceClassType insuranceClassType) {
	id = UUID.randomUUID();
	this.ageClass = ageClass;
	this.driverExpirienceClass = driverExpirienceClass;
	this.idNumber = idNumber;
	this.hasPrivilege = hasPrivilege;
	this.insuranceClassType = insuranceClassType;
    }

    public UUID getId() {
	return id;
    }

    public AgeClass getAgeClass() {
	return ageClass;
    }

    public void setAgeClass(AgeClass ageClass) {
	this.ageClass = ageClass;
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
