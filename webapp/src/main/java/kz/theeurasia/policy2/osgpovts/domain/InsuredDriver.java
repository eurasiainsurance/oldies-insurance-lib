package kz.theeurasia.policy2.osgpovts.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.primefaces.model.UploadedFile;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredAgeClassEnum;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredExpirienceClassEnum;
import kz.theeurasia.esbdproxy.domain.infos.general.IdentityCardInfo;
import kz.theeurasia.esbdproxy.domain.infos.general.OriginInfo;
import kz.theeurasia.esbdproxy.domain.infos.general.PersonalInfo;
import kz.theeurasia.esbdproxy.domain.infos.osgpovts.DriverLicenseInfo;
import kz.theeurasia.esbdproxy.domain.infos.osgpovts.GPWParticipantInfo;
import kz.theeurasia.esbdproxy.domain.infos.osgpovts.InvalidInfo;
import kz.theeurasia.esbdproxy.domain.infos.osgpovts.PensionerInfo;
import kz.theeurasia.esbdproxy.domain.infos.osgpovts.PrivilegerInfo;

public class InsuredDriver {
    private final UUID id = UUID.randomUUID();

    private InsuranceClassTypeDict insuranceClassType = InsuranceClassTypeDict.UNSPECIFIED;

    private String idNumber = "";
    private String taxPayerNumber = "";

    private PersonalInfo personal = new PersonalInfo();
    private OriginInfo origin = new OriginInfo();

    private IdentityCardInfo identityCard = new IdentityCardInfo();
    private List<UploadedFile> identityCardDocuments = new ArrayList<>();

    private InsuredAgeClassEnum ageClass = InsuredAgeClassEnum.UNSPECIFIED;
    private InsuredExpirienceClassEnum expirienceClass = InsuredExpirienceClassEnum.UNSPECIFIED;

    private DriverLicenseInfo driverLicense = new DriverLicenseInfo();
    private List<UploadedFile> driverLicenseDocuments = new ArrayList<>();

    // privileges
    private boolean hasAnyPrivilege = false;

    private boolean priveleger = false;
    private PrivilegerInfo privilegerInfo = new PrivilegerInfo();
    private List<UploadedFile> privilegerDocuments = new ArrayList<>();

    private boolean invalid = false;
    private InvalidInfo invalidInfo = new InvalidInfo();
    private List<UploadedFile> invalidDocuments = new ArrayList<>();

    private boolean gpwParticipant = false;
    private GPWParticipantInfo gpwParticipantInfo = new GPWParticipantInfo();
    private List<UploadedFile> gpwParticipantDocuments = new ArrayList<>();

    private boolean pensioner = false;
    private PensionerInfo pensionerInfo = new PensionerInfo();
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
	return (((getPersonal().getLastName() == null || getPersonal().getLastName().isEmpty()) ? ""
		: (getPersonal().getLastName() + " ")) +
		((getPersonal().getFirstName() == null || getPersonal().getFirstName().isEmpty()) ? ""
			: (getPersonal().getFirstName() + " "))
		+
		((getPersonal().getMiddleName() == null || getPersonal().getMiddleName().isEmpty()) ? ""
			: (getPersonal().getMiddleName() + " "))).trim();
    }

    public boolean isFetched() {
	return fetchedEntity != null;
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

    public PersonalInfo getPersonal() {
	return personal;
    }

    public void setPersonal(PersonalInfo personal) {
	this.personal = personal;
    }

    public OriginInfo getOrigin() {
	return origin;
    }

    public void setOrigin(OriginInfo origin) {
	this.origin = origin;
    }

    public IdentityCardInfo getIdentityCard() {
	return identityCard;
    }

    public void setIdentityCard(IdentityCardInfo identityCard) {
	this.identityCard = identityCard;
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

    public DriverLicenseInfo getDriverLicense() {
	return driverLicense;
    }

    public void setDriverLicense(DriverLicenseInfo driverLicense) {
	this.driverLicense = driverLicense;
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

    public PrivilegerInfo getPrivilegerInfo() {
	return privilegerInfo;
    }

    public void setPrivilegerInfo(PrivilegerInfo privilegerInfo) {
	this.privilegerInfo = privilegerInfo;
    }

    public boolean isInvalid() {
	return invalid;
    }

    public void setInvalid(boolean invalid) {
	this.invalid = invalid;
    }

    public InvalidInfo getInvalidInfo() {
	return invalidInfo;
    }

    public void setInvalidInfo(InvalidInfo invalidInfo) {
	this.invalidInfo = invalidInfo;
    }

    public boolean isGpwParticipant() {
	return gpwParticipant;
    }

    public void setGpwParticipant(boolean gpwParticipant) {
	this.gpwParticipant = gpwParticipant;
    }

    public GPWParticipantInfo getGpwParticipantInfo() {
	return gpwParticipantInfo;
    }

    public void setGpwParticipantInfo(GPWParticipantInfo gpwParticipantInfo) {
	this.gpwParticipantInfo = gpwParticipantInfo;
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

    public PensionerInfo getPensionerInfo() {
	return pensionerInfo;
    }

    public void setPensionerInfo(PensionerInfo pensionerInfo) {
	this.pensionerInfo = pensionerInfo;
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

    public List<UploadedFile> getPrivilegerDocuments() {
	return privilegerDocuments;
    }

    public List<UploadedFile> getInvalidDocuments() {
	return invalidDocuments;
    }
}
