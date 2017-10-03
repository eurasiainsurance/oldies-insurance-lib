package com.lapsa.insurance.domain.casco;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.Locale;
import java.util.StringJoiner;

import com.lapsa.commons.elements.Localized;
import com.lapsa.commons.function.MyOptionals;
import com.lapsa.insurance.domain.DisplayNames;
import com.lapsa.insurance.domain.InsuranceProduct;
import com.lapsa.insurance.domain.InsuranceRequest;
import com.lapsa.insurance.elements.InsuranceProductType;
import com.lapsa.insurance.elements.RequestSource;

public class CascoRequest extends InsuranceRequest {
    private static final long serialVersionUID = -8067548829502589540L;
    private static final int PRIME = 137;
    private static final int MULTIPLIER = PRIME;

    public CascoRequest() {
    }

    public CascoRequest(RequestSource source) {
	super(source);
    }

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private Casco casco = new Casco();

    @Override
    public String displayName(DisplayNameVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(CASCO_REQUEST.displayName(variant, locale));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	MyOptionals.of(id)
		.map(String::valueOf)
		.map(FIELD_NUMBER.fieldAsCaptionMapper(variant, locale))//
		.ifPresent(sj::add);

	MyOptionals.of(created) //
		.map(DisplayNames.instantMapper(locale)) //
		.map(FIELD_REQUEST_CREATED.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(progressStatus)
		.map(Localized.toDisplayNameMapper(variant, locale))
		.map(FIELD_STATUS.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.append(appendEntityId())
		.toString();
    }

    @Override
    public InsuranceProduct getProduct() {
	return casco;
    }

    @Override
    public InsuranceProductType getProductType() {
	return InsuranceProductType.CASCO;
    }

    // GENERATED

    public Casco getCasco() {
	return casco;
    }

    public void setCasco(Casco casco) {
	this.casco = casco;
    }
}
