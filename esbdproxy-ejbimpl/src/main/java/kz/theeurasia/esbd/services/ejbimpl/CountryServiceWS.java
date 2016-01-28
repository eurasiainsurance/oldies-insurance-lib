package kz.theeurasia.esbd.services.ejbimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import kz.theeurasia.asb.esbd.jaxws.Item;
import kz.theeurasia.esbd.domain.CountryInfo;
import kz.theeurasia.esbd.services.CountryServiceDAO;
import kz.theeurasia.esbd.services.NotFound;

@Stateless
public class CountryServiceWS extends ESBDServiceWS implements CountryServiceDAO {

    private static final String DIRECTORY_NAME = "COUNTRIES";

    private List<CountryInfo> all;

    @PostConstruct
    protected void init() {
	// EAGER
	fetchAll();
    }

    private void fetchAll() {
	if (all == null) {
	    checkSession();
	    all = new ArrayList<>();
	    List<Item> items = getSoapService().getItems(getSessionId(), DIRECTORY_NAME).getItem();
	    for (Item source : items) {
		CountryInfo target = new CountryInfo();
		fillValues(source, target);
		all.add(target);
	    }
	}
    }

    void fillValues(Item source, CountryInfo target) {
	target.setId(source.getID());
	target.setName(source.getName());
	target.setCode(source.getCode());
    }

    @Override
    public CountryInfo getById(Long id) throws NotFound {
	fetchAll();
	for (CountryInfo dti : all) {
	    if (dti.getId() == id)
		return dti;
	}
	throw new NotFound();
    }

    @Override
    public List<CountryInfo> getAll() {
	fetchAll();
	return all;
    }

}
