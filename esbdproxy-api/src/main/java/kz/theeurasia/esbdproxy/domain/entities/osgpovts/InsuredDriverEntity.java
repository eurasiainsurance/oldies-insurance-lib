package kz.theeurasia.esbdproxy.domain.entities.osgpovts;

import kz.theeurasia.esbdproxy.domain.dict.MaritalStatusDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuredDriverExpirienceClassComplexDict;
import kz.theeurasia.esbdproxy.domain.entities.IndividualEntity;
import kz.theeurasia.esbdproxy.domain.entities.InsuranceCompanyEntity;
import kz.theeurasia.esbdproxy.domain.infos.RecordOperationInfo;
import kz.theeurasia.esbdproxy.domain.infos.osgpovts.CertificateInfo;
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
    private IndividualEntity insuredPerson;

    // HOUSEHOLD_POSITION_ID s:int Идентификатор семейного положения
    private MaritalStatusDict maritalStatus;

    // AGE_EXPERIENCE_ID s:int Идентификатор возраста\стажа вождения
    private InsuredDriverExpirienceClassComplexDict insuredDriverExpirienceClass;

    // EXPERIENCE s:int Стаж вождения
    private int drivingExpirience;

    // DRIVER_CERTIFICATE s:string Номер водительского удостоверения
    // DRIVER_CERTIFICATE_DATE s:string Дата выдачи водительского удостоверения
    private CertificateInfo driverLicense;

    // getClassId
    private InsuranceClassTypeDict insuraceClassType;

    // PRIVELEGER_BOOL s:int Признак приравненного лица
    private boolean privileger;

    // PRIVELEDGER_TYPE s:string Тип приравненного лица
    // PRIVELEDGER_CERTIFICATE s:string Удостоверение приравненного лица
    // PRIVELEDGER_CERTIFICATE_DATE s:string Дата выдачи удостоверения
    // приравненного лица
    private PrivilegerInfo privilegerInfo;

    // WOW_BOOL s:int Признак участника ВОВ
    private boolean gpwParticipant;

    // WOW_CERTIFICATE s:string Удостоверение участника ВОВ
    // WOW_CERTIFICATE_DATE s:string Дата выдачи удостоверения участника ВОВ
    private GPWParticipantInfo gpwParticipantInfo;

    // PENSIONER_BOOL s:int Признак пенсионера
    private boolean pensioner;

    // PENSIONER_CERTIFICATE s:string Удостоверение пенсионера
    // PENSIONER_CERTIFICATE_DATE s:string Дата выдачи удостоверения пенсионера
    private PensionerInfo pensionerInfo;

    // INVALID_BOOL s:int Признак инвалида
    private boolean invalid;

    // INVALID_CERTIFICATE s:string Удостоверение инвалида
    // INVALID_CERTIFICATE_BEG_DATE s:string Дата выдачи удостоверения инвалида
    // INVALID_CERTIFICATE_END_DATE s:string Дата завершения удостоверения
    // инвалида
    private InvalidInfo invalidInfo;

    // CREATED_BY_USER_ID s:int Идентификатор пользователя, создавшего запись
    // INPUT_DATE s:string Дата\время ввода записи в систему
    private RecordOperationInfo created;

    // RECORD_CHANGED_AT s:string Дата\время изменения записи
    // CHANGED_BY_USER_ID s:int Идентификатор пользователя, изменившего запись
    private RecordOperationInfo modified;

    // SYSTEM_DELIMITER_ID s:int Идентификатор страховой компании
    private InsuranceCompanyEntity insurer;

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

    public IndividualEntity getInsuredPerson() {
	return insuredPerson;
    }

    public void setInsuredPerson(IndividualEntity insuredPerson) {
	this.insuredPerson = insuredPerson;
    }

    public MaritalStatusDict getMaritalStatus() {
	return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatusDict maritalStatus) {
	this.maritalStatus = maritalStatus;
    }

    public InsuredDriverExpirienceClassComplexDict getInsuredDriverExpirienceClass() {
	return insuredDriverExpirienceClass;
    }

    public void setInsuredDriverExpirienceClass(InsuredDriverExpirienceClassComplexDict insuredDriverExpirienceClass) {
	this.insuredDriverExpirienceClass = insuredDriverExpirienceClass;
    }

    public int getDrivingExpirience() {
	return drivingExpirience;
    }

    public void setDrivingExpirience(int drivingExpirience) {
	this.drivingExpirience = drivingExpirience;
    }

    public CertificateInfo getDriverLicense() {
	return driverLicense;
    }

    public void setDriverLicense(CertificateInfo driverLicense) {
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
