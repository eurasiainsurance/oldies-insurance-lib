package kz.theeurasia.esbdproxy.services.ejbimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.esbdproxy.domain.dict.CountryRegionDict;
import kz.theeurasia.esbdproxy.services.CountryRegionServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

@Singleton
public class CountryRegionServiceWS extends ESBDServiceWS implements CountryRegionServiceDAO {

    private List<CountryRegionDict> all;
    private List<CountryRegionDict> regions;

    @PostConstruct
    protected void init() {
	all = new ArrayList<>();
	for (CountryRegionDict cd : CountryRegionDict.values()) {
	    all.add(cd);
	    if (cd.isRegion())
		regions.add(cd);
	}
    }

    @Override
    public CountryRegionDict getById(Long id) throws NotFound {
	CountryRegionDict result = CountryRegionDict.forId(id);
	if (result == null)
	    throw new NotFound("Not found with ID = '" + id + "'");
	return result;
    }

    @Override
    public List<CountryRegionDict> getAll() {
	return all;
    }

    @Override
    public List<CountryRegionDict> getRegions() {
	return regions;
    }

}
