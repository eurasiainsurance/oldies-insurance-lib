package kz.theeurasia.esbd.services.osgpovts;

import java.util.Calendar;

import kz.theeurasia.esbd.domain.ClientInfo;
import kz.theeurasia.esbd.domain.osgpovts.InsuranceClassType;
import kz.theeurasia.esbd.services.NotFound;

public interface InsuranceClassTypeServiceDAO {
    InsuranceClassType getById(Long id) throws NotFound;

    InsuranceClassType getByCode(String code) throws NotFound;

    InsuranceClassType getForClientOnToday(ClientInfo client) throws NotFound;
    
    InsuranceClassType getForClientOnDate(ClientInfo client, Calendar date) throws NotFound;
    
    InsuranceClassType getDefault();
}
