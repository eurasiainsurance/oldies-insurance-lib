package kz.theeurasia.policy.osgpovts.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.primefaces.model.UploadedFile;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredAgeClassEnum;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredExpirienceClassEnum;
import kz.theeurasia.policy.general.domain.IdentityCardData;
import kz.theeurasia.policy.general.domain.OriginData;
import kz.theeurasia.policy.general.domain.PersonalData;
import kz.theeurasia.policy.validator.IdNumber;
import kz.theeurasia.policy.validator.Required;

public class InsuredDriverData {
    private final UUID id = UUID.randomUUID();

    private InsuranceClassTypeDict insuranceClassType = InsuranceClassTypeDict.UNSPECIFIED;

    @Required
    @IdNumber
    private String idNumber = "";
    private String taxPayerNumber = "";

    private PersonalData personalData = new PersonalData();
    private OriginData originData = new OriginData();

    private IdentityCardData identityCardData = new IdentityCardData();
    private List<UploadedFile> identityCardDocuments = new ArrayList<>();

    private InsuredAgeClassEnum ageClass = InsuredAgeClassEnum.UNSPECIFIED;
    private InsuredExpirienceClassEnum expirienceClass = InsuredExpirienceClassEnum.UNSPECIFIED;

    private DriverLicenseData driverLicenseData = new DriverLicenseData();
    private List<UploadedFile> driverLicenseDocuments = new ArrayList<>();

    // privileges
    private boolean hasAnyPrivilege = false;

    private boolean priveleger = false;
    private PrivilegerData privilegerData = new PrivilegerData();
    private List<UploadedFile> privilegerDocuments = new ArrayList<>();

    private boolean handicaped = false;
    private HandicaptedData handicapedData = new HandicaptedData();
    private List<UploadedFile> handicapedDocuments = new ArrayList<>();

    private boolean gpwParticipant = false;
    private GPWParticipantData gpwParticipantData = new GPWParticipantData();
    private List<UploadedFile> gpwParticipantDocuments = new ArrayList<>();

    private boolean pensioner = false;
    private PensionerData pensionerData = new PensionerData();
    private List<UploadedFile> pensionerDocuments = new ArrayList<>();

    // esbd entities
    private SubjectPersonEntity fetchedEntity;

    @Override
    public int hashCode() {
	return this.getClass().hashCode() * id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	return obj != null && this.getClass().isInstance(obj) && getId().equals((this.getClass().cast(obj)).getId());
    }

    public String getDisplayName() {
	return (((getPersonalData().getSurename() == null || getPersonalData().getSurename().isEmpty()) ? ""
		: (getPersonalData().getSurename() + " ")) +
		((getPersonalData().getName() == null || getPersonalData().getName().isEmpty()) ? ""
			: (getPersonalData().getName() + " "))
		+
		((getPersonalData().getPatronymic() == null || getPersonalData().getPatronymic().isEmpty()) ? ""
			: (getPersonalData().getPatronymic() + " "))).trim();
    }

    public boolean isFetched() {
	return fetchedEntity != null;
    }

    public String getSafeId() {
	return id.toString().replaceAll("-", "_");
    }

    // GENERATED

    public UUID getId() {
	return id;
    }

    public InsuranceClassTypeDict getInsuranceClassType() {
	return insuranceClassType;
    }

    public void setInsuranceClassType(InsuranceClassTypeDict insuranceClassType) {
	this.insuranceClassType = insuranceClassType;
    }

    public String getIdNumber() {
	return idNumber;
    }

    public void setIdNumber(String idNumber) {
	this.idNumber = idNumber;
    }

    public String getTaxPayerNumber() {
	return taxPayerNumber;
    }

    public void setTaxPayerNumber(String taxPayerNumber) {
	this.taxPayerNumber = taxPayerNumber;
    }

    public PersonalData getPersonalData() {
	return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
	this.personalData = personalData;
    }

    public OriginData getOriginData() {
	return originData;
    }

    public void setOriginData(OriginData originData) {
	this.originData = originData;
    }

    public IdentityCardData getIdentityCardData() {
	return identityCardData;
    }

    public void setIdentityCardData(IdentityCardData identityCardData) {
	this.identityCardData = identityCardData;
    }

    public List<UploadedFile> getIdentityCardDocuments() {
	return identityCardDocuments;
    }

    public void setIdentityCardDocuments(List<UploadedFile> identityCardDocuments) {
	this.identityCardDocuments = identityCardDocuments;
    }

    public InsuredAgeClassEnum getAgeClass() {
	return ageClass;
    }

    public void setAgeClass(InsuredAgeClassEnum ageClass) {
	this.ageClass = ageClass;
    }

    public InsuredExpirienceClassEnum getExpirienceClass() {
	return expirienceClass;
    }

    public void setExpirienceClass(InsuredExpirienceClassEnum expirienceClass) {
	this.expirienceClass = expirienceClass;
    }

    public DriverLicenseData getDriverLicenseData() {
	return driverLicenseData;
    }

    public void setDriverLicenseData(DriverLicenseData driverLicenseData) {
	this.driverLicenseData = driverLicenseData;
    }

    public List<UploadedFile> getDriverLicenseDocuments() {
	return driverLicenseDocuments;
    }

    public void setDriverLicenseDocuments(List<UploadedFile> driverLicenseDocuments) {
	this.driverLicenseDocuments = driverLicenseDocuments;
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

    public PrivilegerData getPrivilegerData() {
	return privilegerData;
    }

    public void setPrivilegerData(PrivilegerData privilegerData) {
	this.privilegerData = privilegerData;
    }

    public List<UploadedFile> getPrivilegerDocuments() {
	return privilegerDocuments;
    }

    public void setPrivilegerDocuments(List<UploadedFile> privilegerDocuments) {
	this.privilegerDocuments = privilegerDocuments;
    }

    public boolean isHandicaped() {
	return handicaped;
    }

    public void setHandicaped(boolean handicaped) {
	this.handicaped = handicaped;
    }

    public HandicaptedData getHandicapedData() {
	return handicapedData;
    }

    public void setHandicapedData(HandicaptedData handicapedData) {
	this.handicapedData = handicapedData;
    }

    public List<UploadedFile> getHandicapedDocuments() {
	return handicapedDocuments;
    }

    public void setHandicapedDocuments(List<UploadedFile> handicapedDocuments) {
	this.handicapedDocuments = handicapedDocuments;
    }

    public boolean isGpwParticipant() {
	return gpwParticipant;
    }

    public void setGpwParticipant(boolean gpwParticipant) {
	this.gpwParticipant = gpwParticipant;
    }

    public GPWParticipantData getGpwParticipantData() {
	return gpwParticipantData;
    }

    public void setGpwParticipantData(GPWParticipantData gpwParticipantData) {
	this.gpwParticipantData = gpwParticipantData;
    }

    public List<UploadedFile> getGpwParticipantDocuments() {
	return gpwParticipantDocuments;
    }

    public void setGpwParticipantDocuments(List<UploadedFile> gpwParticipantDocuments) {
	this.gpwParticipantDocuments = gpwParticipantDocuments;
    }

    public boolean isPensioner() {
	return pensioner;
    }

    public void setPensioner(boolean pensioner) {
	this.pensioner = pensioner;
    }

    public PensionerData getPensionerData() {
	return pensionerData;
    }

    public void setPensionerData(PensionerData pensionerData) {
	this.pensionerData = pensionerData;
    }

    public List<UploadedFile> getPensionerDocuments() {
	return pensionerDocuments;
    }

    public void setPensionerDocuments(List<UploadedFile> pensionerDocuments) {
	this.pensionerDocuments = pensionerDocuments;
    }

    public SubjectPersonEntity getFetchedEntity() {
	return fetchedEntity;
    }

    public void setFetchedEntity(SubjectPersonEntity fetchedEntity) {
	this.fetchedEntity = fetchedEntity;
    }
}
