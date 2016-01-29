package kz.theeurasia.policy2.osgpovts.domain;

import java.util.UUID;

import org.primefaces.model.UploadedFile;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.entities.IndividualEntity;
import kz.theeurasia.services.domain.osgpovts.DriverExpirienceClass;
import kz.theeurasia.services.domain.osgpovts.InsuredAgeClass;


public class Insured {
    private final UUID id;

    private InsuredAgeClass insuredAgeClass;
    private DriverExpirienceClass driverExpirienceClass;
    private String idNumber;
    private boolean hasPrivilege;
    private InsuranceClassTypeDict insuranceClassType;
    private IndividualEntity client;

    private UploadedFile idCardScanCopy;
    private UploadedFile driverCertificateScanCopy;

    public Insured() {
	id = UUID.randomUUID();
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

    public InsuranceClassTypeDict getInsuranceClassType() {
	return insuranceClassType;
    }

    public void setInsuranceClassType(InsuranceClassTypeDict insuranceClassType) {
	this.insuranceClassType = insuranceClassType;
    }

    public IndividualEntity getClient() {
	return client;
    }

    public void setClient(IndividualEntity client) {
	this.client = client;
    }

    public UploadedFile getIdCardScanCopy() {
	return idCardScanCopy;
    }

    public void setIdCardScanCopy(UploadedFile idCardScanCopy) {
	this.idCardScanCopy = idCardScanCopy;
    }

    public UploadedFile getDriverCertificateScanCopy() {
	return driverCertificateScanCopy;
    }

    public void setDriverCertificateScanCopy(UploadedFile driverCertificateScanCopy) {
	this.driverCertificateScanCopy = driverCertificateScanCopy;
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
