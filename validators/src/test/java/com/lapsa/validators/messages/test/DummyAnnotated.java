package com.lapsa.validators.messages.test;

import com.lapsa.insurance.validation.DaysAfterNow;
import com.lapsa.insurance.validation.DaysBeforeNow;
import com.lapsa.insurance.validation.Mode;
import com.lapsa.insurance.validation.NotEmptyString;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.insurance.validation.ValidDateOfBirth;
import com.lapsa.insurance.validation.ValidDateOfIssue;
import com.lapsa.insurance.validation.ValidEnumerationValue;
import com.lapsa.insurance.validation.ValidIdentityCardType;
import com.lapsa.insurance.validation.ValidInsuranceAgeClass;
import com.lapsa.insurance.validation.ValidInsuranceExpirienceClass;
import com.lapsa.insurance.validation.ValidSex;
import com.lapsa.insurance.validation.ValidVehicleAgeClass;
import com.lapsa.insurance.validation.ValidVehicleClass;
import com.lapsa.insurance.validation.ValidVehicleRegistrationNumber;
import com.lapsa.insurance.validation.ValidVehicleYearOfIssue;

public interface DummyAnnotated {

    @DaysAfterNow(mode = Mode.MUST, value = 1)
    @DaysBeforeNow(mode = Mode.MUST, value = 1)
    @NotEmptyString
    @NotNullValue
    @ValidDateOfBirth
    @ValidDateOfIssue
    @ValidEnumerationValue
    @ValidIdentityCardType
    @ValidInsuranceAgeClass
    @ValidInsuranceExpirienceClass
    @ValidSex
    @ValidVehicleAgeClass
    @ValidVehicleClass
    @ValidVehicleRegistrationNumber
    @ValidVehicleYearOfIssue
    void dummy();
}
