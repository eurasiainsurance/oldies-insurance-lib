package kz.theeurasia.esbdproxy.services.ejbimpl;

import javax.ejb.Singleton;

import kz.theeurasia.esbdproxy.domain.dict.CancelationReasonDict;
import kz.theeurasia.esbdproxy.services.CancelationReasonTypeServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

@Singleton
public class CancelationReasonTypeServiceWS extends ESBDServiceWS implements CancelationReasonTypeServiceDAO {

    @Override
    public CancelationReasonDict getById(Long id) throws NotFound {
	CancelationReasonDict result = CancelationReasonDict.forId(id);
	if (result == null)
	    throw new NotFound("Not found with ID = '" + id + "'");
	return result;
    }
}
