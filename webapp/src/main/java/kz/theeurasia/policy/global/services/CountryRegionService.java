package kz.theeurasia.policy.global.services;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import kz.theeurasia.services.domain.global.CountryRegion;

@ManagedBean(eager = true, name="QQQ")
@ApplicationScoped
public class CountryRegionService {

    public CountryRegion[] getCountryRegions() {
	return CountryRegion.values();
    }
}
