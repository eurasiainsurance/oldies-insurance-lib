package kz.theeurasia.policy2.osgpovts.services;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryRegionDict;
import kz.theeurasia.esbdproxy.services.general.CountryRegionServiceDAO;

@ManagedBean
@ApplicationScoped
public class CountryRegionService {

    @EJB
    private CountryRegionServiceDAO countryRegionServiceDAO;

    public List<CountryRegionDict> getAllItems() {
	return countryRegionServiceDAO.getAll();
    }

    public List<CountryRegionDict> getValidItems() {
	return countryRegionServiceDAO.getRegions();
    }
}
