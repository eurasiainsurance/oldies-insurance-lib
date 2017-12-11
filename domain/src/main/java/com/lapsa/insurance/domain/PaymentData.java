package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.time.Instant;
import java.util.Locale;
import java.util.StringJoiner;

import com.lapsa.insurance.elements.PaymentStatus;

import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.localization.Localized;
import tech.lapsa.java.commons.localization.Localizeds;
import tech.lapsa.javax.validation.NotNullValue;
import tech.lapsa.patterns.domain.HashCodePrime;

@HashCodePrime(127)
public class PaymentData extends Domain {

    private static final long serialVersionUID = 1L;

    @NotNullValue
    private PaymentStatus status = PaymentStatus.UNDEFINED;

    private String invoiceNumber;

    private String paymentReference;
    private Instant paymentInstant;
    private String methodName;
    private Double paymentAmount;

    @Override
    public String localized(LocalizationVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(MyOptionals.of(methodName) //
		.orElseGet(() -> PAYMENT_DATA.localized(variant, locale)));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	MyOptionals.of(status) //
		.filter(PaymentStatus::isDefined) //
		.map(Localized.toLocalizedMapper(variant, locale)) //
		.map(FIELD_STATUS.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(invoiceNumber) //
		.map(PAYMENT_INVOICE_NUMBER.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(paymentInstant) //
		.map(Localizeds.instantMapper(locale)) //
		.map(PAYMENT_POST_INSTANT.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(paymentReference) //
		.map(PAYMENT_POST_REFERENCE.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.toString();
    }

    // GENERATED

    public String getInvoiceNumber() {
	return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
	this.invoiceNumber = invoiceNumber;
    }

    public PaymentStatus getStatus() {
	return status;
    }

    public void setStatus(PaymentStatus status) {
	this.status = status;
    }

    public String getPaymentReference() {
	return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
	this.paymentReference = paymentReference;
    }

    public void setPaymentInstant(Instant paymentInstant) {
	this.paymentInstant = paymentInstant;
    }

    public Instant getPaymentInstant() {
	return paymentInstant;
    }

    public String getMethodName() {
	return methodName;
    }

    public void setMethodName(String methodName) {
	this.methodName = methodName;
    }

    public Double getPaymentAmount() {
	return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
	this.paymentAmount = paymentAmount;
    }
}
