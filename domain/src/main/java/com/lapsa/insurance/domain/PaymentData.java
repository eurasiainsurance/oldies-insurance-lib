package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;

import com.lapsa.commons.function.MyStrings;
import com.lapsa.insurance.elements.PaymentMethod;
import com.lapsa.insurance.elements.PaymentStatus;
import com.lapsa.validation.NotNullValue;

public class PaymentData extends BaseDomain {
    private static final long serialVersionUID = -6326848114328976035L;
    private static final int PRIME = 127;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    @NotNullValue(message = "{com.lapsa.insurance.domain.PaymentData.method.NotNullValue.message}")
    private PaymentMethod method = PaymentMethod.UNDEFINED;

    @NotNullValue
    private PaymentStatus status = PaymentStatus.UNDEFINED;

    private String paymentReference;

    @Override
    public String displayName(DisplayNameVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(Optional.ofNullable(method) //
		.filter(PaymentMethod::isDefined) //
		.map(x -> x.displayName(variant, locale)) //
		.map(MyStrings::capitalizeFirstLetter) //
		.orElseGet(() -> PAYMENT_DATA.displayName(variant, locale)));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	Optional.ofNullable(status) //
		.filter(PaymentStatus::isDefined) //
		.map(x -> x.displayName(variant, locale)) //
		.map(x -> FIELD_STATUS.displayName(variant, locale) + " " + x)
		.ifPresent(sj::add);

	Optional.ofNullable(paymentReference) //
		.filter(MyStrings::nonEmptyString)
		.map(x -> PAYMENT_REFERENCE.displayName(variant, locale) + " " + x)
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.toString();
    }
    
    // GENERATED

    public PaymentMethod getMethod() {
	return method;
    }

    public void setMethod(PaymentMethod method) {
	this.method = method;
    }

    public String getPaymentReference() {
	return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
	this.paymentReference = paymentReference;
    }

    public PaymentStatus getStatus() {
	return status;
    }

    public void setStatus(PaymentStatus status) {
	this.status = status;
    }
}
