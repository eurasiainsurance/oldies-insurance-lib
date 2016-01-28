package kz.theeurasia.services.services;

import kz.theeurasia.services.domain.esbd.ClientInfo;
import kz.theeurasia.services.domain.global.IdNumber;
import kz.theeurasia.services.domain.global.InsuranceClassType;

public interface ESBDAccess {
    InsuranceClassType getInsuranceClassTypeForIndividual(IdNumber idNumber)
	    throws ESBDException, ESBDFaultException;

    ClientInfo fetchClient(IdNumber idNumber) throws ESBDException, ESBDFaultException, NotFound;

}
