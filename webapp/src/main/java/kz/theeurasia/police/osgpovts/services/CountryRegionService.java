package kz.theeurasia.police.osgpovts.services;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import kz.theeurasia.services.domain.CountryRegion;

@ManagedBean(eager = true)
@ApplicationScoped
public class CountryRegionService {

    public CountryRegion[] getCountryRegions() {
	return CountryRegion.values();
    }
}
