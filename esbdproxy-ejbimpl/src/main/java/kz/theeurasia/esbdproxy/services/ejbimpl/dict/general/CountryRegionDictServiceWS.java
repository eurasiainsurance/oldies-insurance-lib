package kz.theeurasia.esbdproxy.services.ejbimpl.dict.general;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryRegionDict;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.CountryRegionServiceDAO;

@Singleton
public class CountryRegionDictServiceWS implements CountryRegionServiceDAO {

    private List<CountryRegionDict> all;
    private List<CountryRegionDict> regions;

    @PostConstruct
    protected void init() {
	all = new ArrayList<>();
	regions = new ArrayList<>();
	for (CountryRegionDict cd : CountryRegionDict.values()) {
	    all.add(cd);
	    if (cd.isRegion())
		regions.add(cd);
	}
    }

    @Override
    public CountryRegionDict getById(Long id) throws NotFound {
	if (id == null)
	    throw new InvalidParameterException("ID must be not null");
	CountryRegionDict result = CountryRegionDict.forId(id);
	if (result == null)
	    throw new NotFound(CountryRegionDict.class.getSimpleName() + " not found with ID = '" + id + "'");
	return result;
    }

    @Override
    public List<CountryRegionDict> getAll() {
	return new ArrayList<>(all);
    }

    @Override
    public List<CountryRegionDict> getRegions() {
	return new ArrayList<>(regions);
    }

    @Override
    public CountryRegionDict getDefaultRegion() {
	return CountryRegionDict.GALM;
    }
}
