package com.lapsa.insurance.esbd.services.elements;

import java.util.Calendar;

import com.lapsa.insurance.elements.InsuranceClassType;
import com.lapsa.insurance.esbd.domain.entities.general.SubjectPersonEntity;
import com.lapsa.insurance.esbd.services.InvalidInputParameter;
import com.lapsa.insurance.esbd.services.NotFound;

public interface InsuranceClassTypeServiceDAO extends ElementsServiceDAO<InsuranceClassType, Integer> {
    InsuranceClassType getByCode(String code) throws NotFound, InvalidInputParameter;

    InsuranceClassType getForSubject(SubjectPersonEntity individual) throws NotFound, InvalidInputParameter;

    InsuranceClassType getForSubject(SubjectPersonEntity individual, Calendar date) throws NotFound, InvalidInputParameter;

    InsuranceClassType getDefault();
}
