package kz.theeurasia.policy.osgpovts.domain;

import java.util.UUID;

import org.primefaces.model.UploadedFile;

import kz.theeurasia.services.domain.esbd.ClientInfo;
import kz.theeurasia.services.domain.global.InsuranceClassType;
import kz.theeurasia.services.domain.osgpovts.DriverExpirienceClass;
import kz.theeurasia.services.domain.osgpovts.InsuredAgeClass;

public class Insured {
    private final UUID id;

    private InsuredAgeClass insuredAgeClass;
    private DriverExpirienceClass driverExpirienceClass;
    private String idNumber;
    private boolean hasPrivilege;
    private InsuranceClassType insuranceClassType;
    private ClientInfo client;

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

    public InsuranceClassType getInsuranceClassType() {
	return insuranceClassType;
    }

    public void setInsuranceClassType(InsuranceClassType insuranceClassType) {
	this.insuranceClassType = insuranceClassType;
    }

    public ClientInfo getClient() {
	return client;
    }

    public void setClient(ClientInfo client) {
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
