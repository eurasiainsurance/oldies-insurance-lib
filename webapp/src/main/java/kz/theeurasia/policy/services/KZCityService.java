package kz.theeurasia.policy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import kz.theeurasia.esbdproxy.domain.dict.general.KZCityDict;
import kz.theeurasia.esbdproxy.services.general.KZCityServiceDAO;

@ManagedBean(name = "kzCityService")
@ApplicationScoped
public class KZCityService {
    @ManagedProperty("#{glb}")
    private ResourceBundle glb;

    @EJB
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

    public List<KZCityDict> getByQuery(String query) {
	return kzCityServiceDAO.getBySearchPattern(query);
    }

    public List<SelectItem> getByQuerySI(String query) {
	return _createSIFromList(getByQuery(query));
    }

    private List<SelectItem> _createSIFromList(List<KZCityDict> list) {
	List<SelectItem> result = new ArrayList<>();
	for (KZCityDict r : list) {
	    SelectItem si = new SelectItem(r, r.getRusname());
	    result.add(si);
	}
	return result;
    }

    // GENERATED

    public void setGlb(ResourceBundle glb) {
	this.glb = glb;
    }

}
