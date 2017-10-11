package com.lapsa.insurance.domain.policy;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.Locale;
import java.util.StringJoiner;

import com.lapsa.insurance.domain.Driver;
import com.lapsa.insurance.domain.PersonalData;
import com.lapsa.insurance.elements.InsuranceClassType;
import com.lapsa.insurance.elements.InsuredAgeClass;
import com.lapsa.insurance.elements.InsuredExpirienceClass;
import com.lapsa.insurance.validation.ValidInsuranceAgeClass;
import com.lapsa.insurance.validation.ValidInsuranceClassType;
import com.lapsa.insurance.validation.ValidInsuranceExpirienceClass;
import com.lapsa.validation.NotNullValue;

import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.localization.Localized;

public class PolicyDriver extends Driver {
    private static final long serialVersionUID = 5209394299289430299L;
    private static final int PRIME = 47;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    @NotNullValue
    @ValidInsuranceClassType
    private InsuranceClassType insuranceClassType;

    @NotNullValue
    @ValidInsuranceAgeClass
    private InsuredAgeClass ageClass;

    @NotNullValue
    @ValidInsuranceExpirienceClass
    private InsuredExpirienceClass expirienceClass;

    private boolean fetched = false;

    // privileges
    private boolean hasAnyPrivilege = false;

    @Override
    public String displayName(DisplayNameVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(POLICY_DRIVER.displayName(variant, locale));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	MyOptionals.of(personalData) //
		.map(PersonalData::getFullName) //
		.ifPresent(sj::add);

	MyOptionals.of(idNumber) //
		.map(FIELD_ID_NUMBER.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(insuranceClassType) //
		.map(Localized.toDisplayNameMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(ageClass) //
		.map(Localized.toDisplayNameMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(expirienceClass) //
		.map(Localized.toDisplayNameMapper(variant, locale)) //
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.append(appendEntityId()) //
		.toString();
    }

    // GENERATED

    public InsuranceClassType getInsuranceClassType() {
	return insuranceClassType;
    }

    public void setInsuranceClassType(InsuranceClassType insuranceClassType) {
	this.insuranceClassType = insuranceClassType;
    }

    public InsuredAgeClass getAgeClass() {
	return ageClass;
    }

    public void setAgeClass(InsuredAgeClass ageClass) {
	this.ageClass = ageClass;
    }

    public InsuredExpirienceClass getExpirienceClass() {
	return expirienceClass;
    }

    public void setExpirienceClass(InsuredExpirienceClass expirienceClass) {
	this.expirienceClass = expirienceClass;
    }

    public boolean isFetched() {
	return fetched;
    }

    public void setFetched(boolean fetched) {
	this.fetched = fetched;
    }

    public boolean isHasAnyPrivilege() {
	return hasAnyPrivilege;
    }

    public void setHasAnyPrivilege(boolean hasAnyPrivilege) {
	this.hasAnyPrivilege = hasAnyPrivilege;
    }
}
