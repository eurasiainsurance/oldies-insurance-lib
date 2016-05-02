package com.lapsa.validators.messages.test;

import kz.theeurasia.policy.validator.NotEmptyString;
import kz.theeurasia.policy.validator.NotNullValue;
import kz.theeurasia.policy.validator.ValidDateOfBirth;
import kz.theeurasia.policy.validator.ValidDateOfIssue;
import kz.theeurasia.policy.validator.ValidEnumerationValue;
import kz.theeurasia.policy.validator.ValidIdentityCardType;
import kz.theeurasia.policy.validator.ValidInsuranceAgeClass;
import kz.theeurasia.policy.validator.ValidInsuranceExpirienceClass;
import kz.theeurasia.policy.validator.ValidSex;
import kz.theeurasia.policy.validator.ValidVehicleAgeClass;
import kz.theeurasia.policy.validator.ValidVehicleClass;
import kz.theeurasia.policy.validator.ValidVehicleRegistrationNumber;
import kz.theeurasia.policy.validator.ValidVehicleYearOfIssue;

public interface DummyAnnotated {

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
