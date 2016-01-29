package kz.theeurasia.esbdproxy.services.ejbimpl;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.Client;
import kz.theeurasia.esbdproxy.domain.entities.ClientEntity;
import kz.theeurasia.esbdproxy.services.ClientServiceDAO;
import kz.theeurasia.esbdproxy.services.LegalServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

@Singleton
public class ClientServiceWS extends ESBDServiceWS implements ClientServiceDAO {

    @EJB
    private ClientServiceDAO individualService;

    @EJB
    private LegalServiceDAO legalService;

    @Override
    public ClientEntity getById(Long id) throws NotFound {
	checkSession();

	Client source = getSoapService().getClientByID(getSessionId(), id.intValue());
	if (source == null)
	    throw new NotFound("Not found with ID = '" + id + "'");

	if (source.getNaturalPersonBool() == 1) {
	    // частник IndividualEntity
	    return individualService.getById(id);
	} else {
	    // юрлицо LegalEntity
	    return legalService.getById(id);
	}
    }

}
