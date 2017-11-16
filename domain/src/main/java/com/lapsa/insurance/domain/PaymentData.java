package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.time.Instant;
import java.util.Locale;
import java.util.StringJoiner;

import com.lapsa.insurance.elements.PaymentMethod;
import com.lapsa.insurance.elements.PaymentStatus;

import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.java.commons.localization.Localizeds;
import tech.lapsa.java.commons.localization.Localized;
import tech.lapsa.javax.validation.NotNullValue;

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

    private String externalId;

    private String paymentReference;
    private Instant paymentInstant;
    private String methodName;

    @Override
    public String localized(LocalizationVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(MyOptionals.of(method) //
		.filter(PaymentMethod::isDefined) //
		.map(Localized.toLocalizedMapper(variant, locale)) //
		.map(MyStrings::capitalizeFirstLetter) //
		.orElseGet(() -> PAYMENT_DATA.localized(variant, locale)));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	MyOptionals.of(status) //
		.filter(PaymentStatus::isDefined) //
		.map(Localized.toLocalizedMapper(variant, locale)) //
		.map(FIELD_STATUS.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(externalId) //
		.map(PAYMENT_EXTERNAL_ID.fieldAsCaptionMapper(variant, locale)) //
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

    public PaymentMethod getMethod() {
	return method;
    }

    public void setMethod(PaymentMethod method) {
	this.method = method;
    }

    public String getExternalId() {
	return externalId;
    }

    public void setExternalId(String externalId) {
	this.externalId = externalId;
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
}
