package com.lapsa.validators.messages.test;

import com.lapsa.insurance.validation.DateFuture;
import com.lapsa.insurance.validation.DateLeftAfterRight;
import com.lapsa.insurance.validation.DateLeftBeforeRight;
import com.lapsa.insurance.validation.DatePast;
import com.lapsa.insurance.validation.DaysAfterNow;
import com.lapsa.insurance.validation.DaysBeforeNow;
import com.lapsa.insurance.validation.Mode;
import com.lapsa.insurance.validation.NotEmptyString;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.insurance.validation.ValidDateOfBirth;
import com.lapsa.insurance.validation.ValidDateOfIssue;
import com.lapsa.insurance.validation.ValidHumanName;
import com.lapsa.insurance.validation.ValidIdentityCardType;
import com.lapsa.insurance.validation.ValidInsuranceAgeClass;
import com.lapsa.insurance.validation.ValidInsuranceExpirienceClass;
import com.lapsa.insurance.validation.ValidSex;
import com.lapsa.insurance.validation.ValidVehicleAgeClass;
import com.lapsa.insurance.validation.ValidVehicleClass;
import com.lapsa.insurance.validation.ValidVehicleRegistrationNumber;
import com.lapsa.insurance.validation.ValidVehicleYearOfIssue;

public interface DummyAnnotated {

    @DateFuture
    @DateLeftAfterRight
    @DateLeftBeforeRight
    @DatePast
    @DaysAfterNow(mode = Mode.MUST, value = 1)
    @DaysBeforeNow(mode = Mode.MUST, value = 1)
    @NotEmptyString
    @NotNullValue
    // @NotTooOldYearOfIssue(maxAge = 1)
    // @NotTooYoungYearOfIssue(minAge = 1)
    @ValidDateOfBirth
    @ValidDateOfIssue
    @ValidIdentityCardType
    @ValidInsuranceAgeClass
    @ValidInsuranceExpirienceClass
    @ValidSex
    @ValidVehicleAgeClass
    @ValidVehicleClass
    @ValidVehicleRegistrationNumber
    @ValidVehicleYearOfIssue
    @ValidHumanName
    void dummy();
}
