package com.lapsa.insurance.domain.policy;

import com.lapsa.insurance.domain.Driver;
import com.lapsa.insurance.domain.GPWParticipantCertificateData;
import com.lapsa.insurance.domain.HandicaptedCertificateData;
import com.lapsa.insurance.domain.PensionerCertificateData;
import com.lapsa.insurance.domain.PrivilegerCertificateData;
import com.lapsa.insurance.elements.InsuranceClassType;
import com.lapsa.insurance.elements.InsuredAgeClass;
import com.lapsa.insurance.elements.InsuredExpirienceClass;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.insurance.validation.ValidInsuranceAgeClass;
import com.lapsa.insurance.validation.ValidInsuranceExpirienceClass;

public class PolicyDriver extends Driver {
    private static final long serialVersionUID = 5209394299289430299L;
    private static final int PRIME = 47;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private InsuranceClassType insuranceClassType;

    @NotNullValue
    @ValidInsuranceAgeClass
    private InsuredAgeClass ageClass;

    @NotNullValue
    @ValidInsuranceExpirienceClass
    private InsuredExpirienceClass expirienceClass;

    private boolean fetched = false;

    // privileges
    private boolean hasAnyPrivilege = false;

    private boolean priveleger = false;
    private PrivilegerCertificateData privilegerCertificateData = new PrivilegerCertificateData();

    private boolean handicaped = false;
    private HandicaptedCertificateData handicapedCertificateData = new HandicaptedCertificateData();

    private boolean gpwParticipant = false;
    private GPWParticipantCertificateData gpwParticipantCertificateData = new GPWParticipantCertificateData();

    private boolean pensioner = false;
    private PensionerCertificateData pensionerCertificateData = new PensionerCertificateData();

    public String getDisplayName() {
	return personalData.getDisplayName();
    }

    @Override
    public String toString() {
	return personalData.getDisplayName();
    }

    @NotNullValue(message = "{com.lapsa.insurance.domain.policy.PolicyDriver.IdNumber.NotNull.message}")
    @Override
    public String getIdNumber() {
	return super.getIdNumber();
    }

    // GENERATED

    public InsuranceClassType getInsuranceClassType() {
	return insuranceClassType;
    }

    public void setInsuranceClassType(InsuranceClassType insuranceClassType) {
	this.insuranceClassType = insuranceClassType;
    }

    public InsuredAgeClass getAgeClass() {
	return ageClass;
    }

    public void setAgeClass(InsuredAgeClass ageClass) {
	this.ageClass = ageClass;
    }

    public InsuredExpirienceClass getExpirienceClass() {
	return expirienceClass;
    }

    public void setExpirienceClass(InsuredExpirienceClass expirienceClass) {
	this.expirienceClass = expirienceClass;
    }

    public boolean isFetched() {
	return fetched;
    }

    public void setFetched(boolean fetched) {
	this.fetched = fetched;
    }

    public boolean isHasAnyPrivilege() {
	return hasAnyPrivilege;
    }

    public void setHasAnyPrivilege(boolean hasAnyPrivilege) {
	this.hasAnyPrivilege = hasAnyPrivilege;
    }

    public boolean isPriveleger() {
	return priveleger;
    }

    public void setPriveleger(boolean priveleger) {
	this.priveleger = priveleger;
    }

    public PrivilegerCertificateData getPrivilegerCertificateData() {
	return privilegerCertificateData;
    }

    public void setPrivilegerCertificateData(PrivilegerCertificateData privilegerCertificateData) {
	this.privilegerCertificateData = privilegerCertificateData;
    }

    public boolean isHandicaped() {
	return handicaped;
    }

    public void setHandicaped(boolean handicaped) {
	this.handicaped = handicaped;
    }

    public HandicaptedCertificateData getHandicapedCertificateData() {
	return handicapedCertificateData;
    }

    public void setHandicapedCertificateData(HandicaptedCertificateData handicapedCertificateData) {
	this.handicapedCertificateData = handicapedCertificateData;
    }

    public boolean isGpwParticipant() {
	return gpwParticipant;
    }

    public void setGpwParticipant(boolean gpwParticipant) {
	this.gpwParticipant = gpwParticipant;
    }

    public GPWParticipantCertificateData getGpwParticipantCertificateData() {
	return gpwParticipantCertificateData;
    }

    public void setGpwParticipantCertificateData(GPWParticipantCertificateData gpwParticipantCertificateData) {
	this.gpwParticipantCertificateData = gpwParticipantCertificateData;
    }

    public boolean isPensioner() {
	return pensioner;
    }

    public void setPensioner(boolean pensioner) {
	this.pensioner = pensioner;
    }

    public PensionerCertificateData getPensionerCertificateData() {
	return pensionerCertificateData;
    }

    public void setPensionerCertificateData(PensionerCertificateData pensionerCertificateData) {
	this.pensionerCertificateData = pensionerCertificateData;
    }
}
