package kz.theeurasia.policy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryRegionDict;
import kz.theeurasia.esbdproxy.services.general.CountryRegionServiceDAO;
import kz.theeurasia.policy.view.GlobalMessageBundleCode;

@ManagedBean
@ApplicationScoped
public class CountryRegionService {

    @ManagedProperty("#{glb}")
    private ResourceBundle glb;

    @EJB
    private CountryRegionServiceDAO countryRegionServiceDAO;

    public List<CountryRegionDict> getAllItems() {
	return countryRegionServiceDAO.getAll();
    }

    public List<CountryRegionDict> getValidItems() {
	return countryRegionServiceDAO.getRegions();
    }

    public List<SelectItem> getValidItemsSI() {
	return _createSIFromList(getValidItems());
    }

    public List<SelectItem> getAllItemsSI() {
	return _createSIFromList(getAllItems());
    }

    private List<SelectItem> _createSIFromList(List<CountryRegionDict> list) {
	List<SelectItem> result = new ArrayList<>();
	for (CountryRegionDict r : list) {
	    SelectItem si = new SelectItem(r,
		    glb.getString(
			    GlobalMessageBundleCode.LABEL_SI_COUNTRY_REGION_PREFIX.getMessageBundleCode() + r.name()));
	    result.add(si);
	}
	return result;
    }

    // GENERATED

    public void setGlb(ResourceBundle glb) {
	this.glb = glb;
    }

}
