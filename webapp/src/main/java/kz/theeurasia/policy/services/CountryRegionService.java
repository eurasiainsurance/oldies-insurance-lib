package kz.theeurasia.policy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryRegionDict;
import kz.theeurasia.esbdproxy.services.general.CountryRegionServiceDAO;
import kz.theeurasia.policy.view.GlobalMessageBundleCode;

@Named
@ApplicationScoped
public class CountryRegionService {

    @Inject
    private ResourceBundle glb;

    @Inject
    private CountryRegionServiceDAO countryRegionServiceDAO;

    public List<CountryRegionDict> getAllItems() {
	return countryRegionServiceDAO.getAll();
    }

    public List<SelectItem> getAllItemsSI() {
	return _createSIFromList(getAllItems());
    }

    public List<CountryRegionDict> getSelectableItems() {
	return countryRegionServiceDAO.getSelectable();
    }

    public List<SelectItem> getSelectableItemsSI() {
	return _createSIFromList(getSelectableItems());
    }

    private List<SelectItem> _createSIFromList(List<CountryRegionDict> list) {
	List<SelectItem> result = new ArrayList<>();
	for (CountryRegionDict r : list) {
	    SelectItem si = new SelectItem(r, glb.getString(
		    GlobalMessageBundleCode.LABEL_SI_COUNTRY_REGION_PREFIX.getMessageBundleCode() + r.name()));
	    result.add(si);
	}
	return result;
    }
}
