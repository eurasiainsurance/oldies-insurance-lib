package kz.theeurasia.esbdproxy.services.ejbimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import kz.theeurasia.esbdproxy.dict.CountryRegionDict;
import kz.theeurasia.esbdproxy.services.CountryRegionServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

@Stateless
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
	    throw new NotFound();
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
