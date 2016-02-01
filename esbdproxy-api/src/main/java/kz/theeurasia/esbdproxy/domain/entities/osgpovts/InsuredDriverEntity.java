package kz.theeurasia.esbdproxy.domain.entities.osgpovts;

import kz.theeurasia.esbdproxy.domain.dict.general.MaritalStatusDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuredAgeExpirienceClassDict;
import kz.theeurasia.esbdproxy.domain.entities.general.InsuranceCompanyEntity;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredExpirienceClassEnum;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredAgeClassEnum;
import kz.theeurasia.esbdproxy.domain.infos.general.RecordOperationInfo;
import kz.theeurasia.esbdproxy.domain.infos.osgpovts.DriverLicenseInfo;
import kz.theeurasia.esbdproxy.domain.infos.osgpovts.GPWParticipantInfo;
import kz.theeurasia.esbdproxy.domain.infos.osgpovts.InvalidInfo;
import kz.theeurasia.esbdproxy.domain.infos.osgpovts.PensionerInfo;
import kz.theeurasia.esbdproxy.domain.infos.osgpovts.PrivilegerInfo;

public class InsuredDriverEntity {
    // DRIVER_ID s:int Идентификатор водителя
    private long id;

    // POLICY_ID s:int Идентификатор полиса
    private PolicyEntity policy;

    // CLIENT_ID s:int Идентификатор клиента (обязательно)
    private SubjectPersonEntity insuredPerson;

    // HOUSEHOLD_POSITION_ID s:int Идентификатор семейного положения
    private MaritalStatusDict maritalStatus = MaritalStatusDict.UNSPECIFIED;

    // AGE_EXPERIENCE_ID s:int Идентификатор возраста\стажа вождения
    private InsuredAgeExpirienceClassDict insuredAgeExpirienceClass = InsuredAgeExpirienceClassDict.UNSPECIFIED;

    // EXPERIENCE s:int Стаж вождения
    private int drivingExpirience;

    // DRIVER_CERTIFICATE s:string Номер водительского удостоверения
    // DRIVER_CERTIFICATE_DATE s:string Дата выдачи водительского удостоверения
    private DriverLicenseInfo driverLicense = new DriverLicenseInfo();

    // getClassId
    private InsuranceClassTypeDict insuraceClassType = InsuranceClassTypeDict.UNSPECIFIED;

    // PRIVELEGER_BOOL s:int Признак приравненного лица
    // PRIVELEDGER_TYPE s:string Тип приравненного лица
    // PRIVELEDGER_CERTIFICATE s:string Удостоверение приравненного лица
    // PRIVELEDGER_CERTIFICATE_DATE s:string Дата выдачи удостоверения
    // приравненного лица
    private boolean privileger = false;
    private PrivilegerInfo privilegerInfo = new PrivilegerInfo();

    // WOW_BOOL s:int Признак участника ВОВ
    // WOW_CERTIFICATE s:string Удостоверение участника ВОВ
    // WOW_CERTIFICATE_DATE s:string Дата выдачи удостоверения участника ВОВ
    private boolean gpwParticipant = false;
    private GPWParticipantInfo gpwParticipantInfo = new GPWParticipantInfo();

    // PENSIONER_BOOL s:int Признак пенсионера
    // PENSIONER_CERTIFICATE s:string Удостоверение пенсионера
    // PENSIONER_CERTIFICATE_DATE s:string Дата выдачи удостоверения пенсионера
    private boolean pensioner = false;
    private PensionerInfo pensionerInfo = new PensionerInfo();

    // INVALID_BOOL s:int Признак инвалида
    // INVALID_CERTIFICATE s:string Удостоверение инвалида
    // INVALID_CERTIFICATE_BEG_DATE s:string Дата выдачи удостоверения инвалида
    // INVALID_CERTIFICATE_END_DATE s:string Дата завершения удостоверения
    // инвалида
    private boolean invalid = false;
    private InvalidInfo invalidInfo = new InvalidInfo();

    // CREATED_BY_USER_ID s:int Идентификатор пользователя, создавшего запись
    // INPUT_DATE s:string Дата\время ввода записи в систему
    private RecordOperationInfo created = new RecordOperationInfo();

    // RECORD_CHANGED_AT s:string Дата\время изменения записи
    // CHANGED_BY_USER_ID s:int Идентификатор пользователя, изменившего запись
    private RecordOperationInfo modified = new RecordOperationInfo();

    // SYSTEM_DELIMITER_ID s:int Идентификатор страховой компании
    private InsuranceCompanyEntity insurer;

    @Override
    public int hashCode() {
	return this.getClass().hashCode() * new Long(id).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	return obj != null && this.getClass().isInstance(obj) && getId() == this.getClass().cast(obj).getId();
    }

    public InsuredAgeClassEnum getAgeClass() {
	return insuredAgeExpirienceClass.getAgeClass();
    }

    public void setAgeClass(InsuredAgeClassEnum ageClass) {
	insuredAgeExpirienceClass = InsuredAgeExpirienceClassDict
		.forPair(insuredAgeExpirienceClass.getExpirienceClass(), ageClass);
    }

    public InsuredExpirienceClassEnum getExpirienceClass() {
	return insuredAgeExpirienceClass.getExpirienceClass();
    }

    public void setExpirienceClass(InsuredExpirienceClassEnum expirienceClass) {
	insuredAgeExpirienceClass = InsuredAgeExpirienceClassDict
		.forPair(expirienceClass, insuredAgeExpirienceClass.getAgeClass());
    }

    // GENERATED

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public PolicyEntity getPolicy() {
	return policy;
    }

    public void setPolicy(PolicyEntity policy) {
	this.policy = policy;
    }

    public SubjectPersonEntity getInsuredPerson() {
	return insuredPerson;
    }

    public void setInsuredPerson(SubjectPersonEntity insuredPerson) {
	this.insuredPerson = insuredPerson;
    }

    public MaritalStatusDict getMaritalStatus() {
	return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatusDict maritalStatus) {
	this.maritalStatus = maritalStatus;
    }

    public InsuredAgeExpirienceClassDict getInsuredAgeExpirienceClass() {
	return insuredAgeExpirienceClass;
    }

    public void setInsuredAgeExpirienceClass(InsuredAgeExpirienceClassDict insuredAgeExpirienceClass) {
	this.insuredAgeExpirienceClass = insuredAgeExpirienceClass;
    }

    public int getDrivingExpirience() {
	return drivingExpirience;
    }

    public void setDrivingExpirience(int drivingExpirience) {
	this.drivingExpirience = drivingExpirience;
    }

    public DriverLicenseInfo getDriverLicense() {
	return driverLicense;
    }

    public void setDriverLicense(DriverLicenseInfo driverLicense) {
	this.driverLicense = driverLicense;
    }

    public InsuranceClassTypeDict getInsuraceClassType() {
	return insuraceClassType;
    }

    public void setInsuraceClassType(InsuranceClassTypeDict insuraceClassType) {
	this.insuraceClassType = insuraceClassType;
    }

    public boolean isPrivileger() {
	return privileger;
    }

    public void setPrivileger(boolean privileger) {
	this.privileger = privileger;
    }

    public PrivilegerInfo getPrivilegerInfo() {
	return privilegerInfo;
    }

    public void setPrivilegerInfo(PrivilegerInfo privilegerInfo) {
	this.privilegerInfo = privilegerInfo;
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

    public RecordOperationInfo getCreated() {
	return created;
    }

    public void setCreated(RecordOperationInfo created) {
	this.created = created;
    }

    public RecordOperationInfo getModified() {
	return modified;
    }

    public void setModified(RecordOperationInfo modified) {
	this.modified = modified;
    }

    public InsuranceCompanyEntity getInsurer() {
	return insurer;
    }

    public void setInsurer(InsuranceCompanyEntity insurer) {
	this.insurer = insurer;
    }

}
