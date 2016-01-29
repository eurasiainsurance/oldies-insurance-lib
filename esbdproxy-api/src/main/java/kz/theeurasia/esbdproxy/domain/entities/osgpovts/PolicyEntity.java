package kz.theeurasia.esbdproxy.domain.entities.osgpovts;

import java.util.Calendar;
import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.CancelationReasonDict;
import kz.theeurasia.esbdproxy.domain.entities.BranchEntity;
import kz.theeurasia.esbdproxy.domain.entities.ClientEntity;
import kz.theeurasia.esbdproxy.domain.entities.InsuranceCompanyEntity;

public class PolicyEntity {
    // POLICY_ID s:int Идентификатор полиса (обязательно)
    private long id;

    // POLICY_NUMBER s:string Номер полиса (обязательно)
    private String number;

    // DATE_BEG s:string Дата начала действия полиса (обязательно)
    private Calendar validFrom;

    // DATE_END s:string Дата окончания действия полиса (обязательно)
    private Calendar validTill;

    // PREMIUM s:double Страховая премия (обязательно)
    private double actualPremiumCost;

    // CALCULATED_PREMIUM s:double Страховая премия рассчитанная системой
    private double premiumCost;

    // SYSTEM_DELIMITER_ID s:int Идентификатор страховой компании
    private InsuranceCompanyEntity insurer;

    // CLIENT_ID s:int Идентификатор страхователя (обязательно)
    private ClientEntity insurant;

    //TODO Добавить поля Changed
    // RECORD_CHANGED_AT s:string Дата\время изменения полиса
    // RECORD_CHANGED_AT_DATETIME s:string Дата\время изменения полиса
    // CHANGED_BY_USER_ID s:int Идентификатор пользователя, изменившего полис

    // CREATED_BY_USER_ID s:int Идентификатор пользователя, создавшего полис
    // INPUT_DATE s:string Дата\время ввода полиса в систему

    // POLICY_DATE s:string Дата полиса
    private Calendar dateOfIssue;

    // RESCINDING_DATE s:string Дата расторжения полиса
    private Calendar dateOfCancelation;

    // RESCINDING_REASON_ID s:int Идентификатор причины расторжения
    private CancelationReasonDict cancelationReasonType;

    // BRANCH_ID s:int Филиал (обязательно)
    private BranchEntity branch;

    // REWRITE_BOOL s:int Признак переоформления
    // REWRITE_POLICY_ID s:int Ссылка на переоформляемый полис

    // DESCRIPTION s:string Комментарии к полису
    private String comments;

    // Drivers tns:ArrayOfDriver Водители (обязательно)
    private List<InsuredDriverEntity> insuredDrivers;

    // PoliciesTF tns:ArrayOfPolicies_TF Транспортные средства полиса
    // (обязательно)
    private List<InsuredVehicleEntity> insuredVehicles;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	this.number = number;
    }

    public Calendar getValidFrom() {
	return validFrom;
    }

    public void setValidFrom(Calendar validFrom) {
	this.validFrom = validFrom;
    }

    public Calendar getValidTill() {
	return validTill;
    }

    public void setValidTill(Calendar validTill) {
	this.validTill = validTill;
    }

    public double getActualPremiumCost() {
	return actualPremiumCost;
    }

    public void setActualPremiumCost(double actualPremiumCost) {
	this.actualPremiumCost = actualPremiumCost;
    }

    public double getPremiumCost() {
	return premiumCost;
    }

    public void setPremiumCost(double premiumCost) {
	this.premiumCost = premiumCost;
    }

    public InsuranceCompanyEntity getInsurer() {
	return insurer;
    }

    public void setInsurer(InsuranceCompanyEntity insurer) {
	this.insurer = insurer;
    }

    public ClientEntity getInsurant() {
	return insurant;
    }

    public void setInsurant(ClientEntity insurant) {
	this.insurant = insurant;
    }

    public Calendar getDateOfIssue() {
	return dateOfIssue;
    }

    public void setDateOfIssue(Calendar dateOfIssue) {
	this.dateOfIssue = dateOfIssue;
    }

    public Calendar getDateOfCancelation() {
	return dateOfCancelation;
    }

    public void setDateOfCancelation(Calendar dateOfCancelation) {
	this.dateOfCancelation = dateOfCancelation;
    }

    public CancelationReasonDict getCancelationReasonType() {
	return cancelationReasonType;
    }

    public void setCancelationReasonType(CancelationReasonDict cancelationReasonType) {
	this.cancelationReasonType = cancelationReasonType;
    }

    public BranchEntity getBranch() {
	return branch;
    }

    public void setBranch(BranchEntity branch) {
	this.branch = branch;
    }

    public String getComments() {
	return comments;
    }

    public void setComments(String comments) {
	this.comments = comments;
    }

    public List<InsuredDriverEntity> getInsuredDrivers() {
	return insuredDrivers;
    }

    public void setInsuredDrivers(List<InsuredDriverEntity> insuredDrivers) {
	this.insuredDrivers = insuredDrivers;
    }

    public List<InsuredVehicleEntity> getInsuredVehicles() {
	return insuredVehicles;
    }

    public void setInsuredVehicles(List<InsuredVehicleEntity> insuredVehicles) {
	this.insuredVehicles = insuredVehicles;
    }

    // GLOBAL_ID s:string Уникальный глобальный идентификатор полиса
    // ScheduledPayments tns:ArrayOfSCHEDULED_PAYMENT Плановые платежи по полису
    // PAYMENT_ORDER_TYPE_ID s:int Порядок оплаты (Идентификатор)
    // PAYMENT_ORDER_TYPE s:string Порядок оплаты
    // PAYMENT_DATE s:string Дата оплаты
    // MIDDLEMAN_ID s:int Посредник (Идентификатор)
    // MIDDLEMAN_CONTRACT_NUMBER s:string Номер договора посредника
    // CLIENT_FORM_ID s:int Форма клиента (справочник CLIENT_FORMS)

}
