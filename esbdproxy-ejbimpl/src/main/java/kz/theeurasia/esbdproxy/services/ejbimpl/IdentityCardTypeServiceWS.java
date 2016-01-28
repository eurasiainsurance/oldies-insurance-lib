package kz.theeurasia.esbdproxy.services.ejbimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import kz.theeurasia.asb.esbd.jaxws.Item;
import kz.theeurasia.esbdproxy.domain.IdentityCardTypeInfo;
import kz.theeurasia.esbdproxy.services.IdentityCardTypeServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

@Stateless
public class IdentityCardTypeServiceWS extends ESBDServiceWS implements IdentityCardTypeServiceDAO {

    private static final String DIRECTORY_NAME = "DOCUMENTS_TYPES";

    private List<IdentityCardTypeInfo> all;

    @PostConstruct
    protected void init() {
	// EAGER
	fetchAll();
    }

    private void fetchAll() {
	checkSession();
	all = new ArrayList<>();
	List<Item> items = getSoapService().getItems(getSessionId(), DIRECTORY_NAME).getItem();
	for (Item source : items) {
	    IdentityCardTypeInfo target = new IdentityCardTypeInfo();
	    fillValues(source, target);
	    all.add(target);
	}
    }

    void fillValues(Item source, IdentityCardTypeInfo target) {
	target.setId(source.getID());
	target.setName(source.getName());
    }

    @Override
    public IdentityCardTypeInfo getById(Long id) throws NotFound {
	for (IdentityCardTypeInfo dti : all) {
	    if (dti.getId() == id)
		return dti;
	}
	throw new NotFound();
    }

    @Override
    public List<IdentityCardTypeInfo> getAll() {
	return all;
    }

}
