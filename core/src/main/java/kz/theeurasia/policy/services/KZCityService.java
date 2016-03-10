package kz.theeurasia.policy.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import kz.theeurasia.esbdproxy.domain.dict.general.KZCityDict;
import kz.theeurasia.esbdproxy.services.general.KZCityServiceDAO;

@Named("kzCityService")
@ApplicationScoped
public class KZCityService {

    @Inject
    private KZCityServiceDAO kzCityServiceDAO;

    public List<KZCityDict> getAllItems() {
	return kzCityServiceDAO.getAll();
    }

    public List<KZCityDict> getSelectableItems() {
	return kzCityServiceDAO.getSelectable();
    }

    public List<SelectItem> getAllItemsSI() {
	return _createSIFromList(getAllItems());
    }

    public List<SelectItem> getSelectableItemsSI() {
	return _createSIFromList(getSelectableItems());
    }

    private List<SelectItem> _createSIFromList(List<KZCityDict> list) {
	List<SelectItem> result = new ArrayList<>();
	for (KZCityDict r : list) {
	    SelectItem si = new SelectItem(r, r.getRusname());
	    result.add(si);
	}
	return result;
    }
}
