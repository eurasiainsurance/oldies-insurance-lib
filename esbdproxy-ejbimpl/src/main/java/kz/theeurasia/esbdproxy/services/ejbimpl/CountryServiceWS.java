package kz.theeurasia.esbdproxy.services.ejbimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import kz.theeurasia.esbdproxy.dict.CountryDict;
import kz.theeurasia.esbdproxy.services.CountryServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

@Stateless
public class CountryServiceWS extends ESBDServiceWS implements CountryServiceDAO {

    private List<CountryDict> all;

    @PostConstruct
    protected void init() {
	all = new ArrayList<>();
	for (CountryDict cd : CountryDict.values())
	    all.add(cd);
    }

    @Override
    public CountryDict getById(Long id) throws NotFound {
	CountryDict result = CountryDict.forId(id);
	if (result == null)
	    throw new NotFound();
	return result;
    }

    @Override
    public List<CountryDict> getAll() {
	return all;
    }

}
