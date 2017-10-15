package com.lapsa.insurance.domain;

import com.lapsa.insurance.elements.InsuranceProductType;
import com.lapsa.insurance.elements.InsuranceRequestType;
import com.lapsa.insurance.elements.RequestSource;
import com.lapsa.insurance.elements.TransactionProblem;
import com.lapsa.insurance.elements.TransactionStatus;

import tech.lapsa.javax.validation.NotNullValue;

public abstract class InsuranceRequest extends Request {
    private static final long serialVersionUID = 944531653617396366L;

    public InsuranceRequest() {
    }

    public InsuranceRequest(RequestSource source) {
	super(source);
    }

    @NotNullValue
    protected InsuranceRequestType type = InsuranceRequestType.UNCOMPLETE;

    @NotNullValue
    protected TransactionStatus transactionStatus;

    @NotNullValue
    protected TransactionProblem transactionProblem;

    @NotNullValue
    protected String agreementNumber;

    protected ObtainingData obtaining = new ObtainingData();
    protected PaymentData payment = new PaymentData();

    public abstract InsuranceProduct getProduct();

    public abstract InsuranceProductType getProductType();

    // GENERATED

    public InsuranceRequestType getType() {
	return type;
    }

    public void setType(InsuranceRequestType type) {
	this.type = type;
    }

    public TransactionStatus getTransactionStatus() {
	return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
	this.transactionStatus = transactionStatus;
    }

    public TransactionProblem getTransactionProblem() {
	return transactionProblem;
    }

    public void setTransactionProblem(TransactionProblem transactionProblem) {
	this.transactionProblem = transactionProblem;
    }

    public ObtainingData getObtaining() {
	return obtaining;
    }

    public void setObtaining(ObtainingData btaining) {
	this.obtaining = btaining;
    }

    public PaymentData getPayment() {
	return payment;
    }

    public void setPayment(PaymentData payment) {
	this.payment = payment;
    }

    public String getAgreementNumber() {
	return agreementNumber;
    }

    public void setAgreementNumber(String agreementNumber) {
	this.agreementNumber = agreementNumber;
    }
}
