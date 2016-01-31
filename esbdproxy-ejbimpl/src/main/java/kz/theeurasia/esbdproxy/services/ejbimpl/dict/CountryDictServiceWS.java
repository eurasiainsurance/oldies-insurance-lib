package kz.theeurasia.esbdproxy.services.ejbimpl.dict;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.esbdproxy.domain.dict.CountryDict;
import kz.theeurasia.esbdproxy.services.CountryServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

@Singleton
public class CountryDictServiceWS implements CountryServiceDAO {

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
	    throw new NotFound(CountryDict.class.getSimpleName() + " not found with ID = '" + id + "'");
	return result;
    }

    @Override
    public List<CountryDict> getAll() {
	return new ArrayList<>(all);
    }

}
