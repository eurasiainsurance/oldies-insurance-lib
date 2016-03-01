package kz.theeurasia.policy.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryDict;
import kz.theeurasia.esbdproxy.services.general.CountryServiceDAO;

@Named
@ApplicationScoped
public class CountryService {

    @Inject
    private CountryServiceDAO countryServiceDAO;

    public List<CountryDict> getAllItems() {
	return countryServiceDAO.getAll();
    }

    public List<SelectItem> getAllItemsSI() {
	return _createSIFromList(getAllItems());
    }

    public List<CountryDict> getSelectableItems() {
	return countryServiceDAO.getSelectable();
    }

    public List<SelectItem> getSelectableItemsSI() {
	return _createSIFromList(getSelectableItems());
    }

    public List<CountryDict> getCountriesByQuery(String query) {
	return countryServiceDAO.getBySearchPattern(query);
    }

    public List<SelectItem> getCountriesByQuerySI(String query) {
	return _createSIFromList(countryServiceDAO.getBySearchPattern(query));
    }

    private List<SelectItem> _createSIFromList(List<CountryDict> list) {
	List<SelectItem> result = new ArrayList<>();
	for (CountryDict r : list) {
	    SelectItem si = new SelectItem(r, r.getRusname());
	    result.add(si);
	}
	return result;
    }
}
