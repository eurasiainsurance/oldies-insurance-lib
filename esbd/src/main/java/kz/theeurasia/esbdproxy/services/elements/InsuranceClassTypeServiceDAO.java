package kz.theeurasia.esbdproxy.services.elements;

import java.util.Calendar;

import com.lapsa.insurance.elements.InsuranceClassType;

import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;
import kz.theeurasia.esbdproxy.services.NotFound;

public interface InsuranceClassTypeServiceDAO extends ElementsServiceDAO<InsuranceClassType, Integer> {
    InsuranceClassType getByCode(String code) throws NotFound, InvalidInputParameter;

    InsuranceClassType getForSubject(SubjectPersonEntity individual) throws NotFound, InvalidInputParameter;

    InsuranceClassType getForSubject(SubjectPersonEntity individual, Calendar date) throws NotFound, InvalidInputParameter;

    InsuranceClassType getDefault();
}
