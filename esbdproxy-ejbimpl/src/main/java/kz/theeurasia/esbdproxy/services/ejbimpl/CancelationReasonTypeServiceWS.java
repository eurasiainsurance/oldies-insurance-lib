package kz.theeurasia.esbdproxy.services.ejbimpl;

import javax.ejb.Stateless;

import kz.theeurasia.esbdproxy.dict.CancelationReasonDict;
import kz.theeurasia.esbdproxy.services.CancelationReasonTypeServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

@Stateless
public class CancelationReasonTypeServiceWS extends ESBDServiceWS implements CancelationReasonTypeServiceDAO {

    @Override
    public CancelationReasonDict getById(Long id) throws NotFound {
	CancelationReasonDict result = CancelationReasonDict.forId(id);
	if (result == null)
	    throw new NotFound("CancelationReasonTypeInfo type '" + id + "' is not recognized");
	return result;
    }
}
