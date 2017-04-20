package com.lapsa.validators.messages.test;

import com.lapsa.insurance.validation.ValidIdentityCardType;
import com.lapsa.insurance.validation.ValidInsuranceAgeClass;
import com.lapsa.insurance.validation.ValidInsuranceClassType;
import com.lapsa.insurance.validation.ValidInsuranceExpirienceClass;
import com.lapsa.insurance.validation.ValidSex;
import com.lapsa.insurance.validation.ValidVehicleAgeClass;
import com.lapsa.insurance.validation.ValidVehicleClass;
import com.lapsa.insurance.validation.ValidVehicleRegistrationNumber;
import com.lapsa.insurance.validation.ValidVehicleYearOfIssue;

public interface DummyAnnotated {
    @ValidIdentityCardType
    @ValidInsuranceAgeClass
    @ValidInsuranceExpirienceClass
    @ValidSex
    @ValidVehicleAgeClass
    @ValidVehicleClass
    @ValidVehicleRegistrationNumber
    @ValidVehicleYearOfIssue
    @ValidInsuranceClassType
    void dummy();
}
