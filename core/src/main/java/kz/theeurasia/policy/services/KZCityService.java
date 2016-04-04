
package kz.theeurasia.policy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.lapsa.country.Country;
import com.lapsa.kz.country.KZCity;

@Named("kzCityService")
@ApplicationScoped
public class KZCityService {

    @Inject
    private LocaleService localeService;

    private ResourceBundle resources;

    @PostConstruct
    public void init() {
	resources = ResourceBundle.getBundle(KZCity.BUNDLE_BASENAME, localeService.getLocale());
    }

    public List<Country> getAllItems() {
	return CollectionUtils.toList(Country.values());
    }

    public List<SelectItem> getAllItemsSI() {
	return _createSIFromList(getAllItems());
    }

    public List<Country> getSelectableItems() {
	List<Country> ret = new ArrayList<>();
	for (Country t : Country.values())
	    if (t.isActual())
		ret.add(t);
	return ret;
    }

    public List<SelectItem> getSelectableItemsSI() {
	return _createSIFromList(getSelectableItems());
    }

    private List<SelectItem> _createSIFromList(List<Country> list) {
	List<SelectItem> result = new ArrayList<>();
	for (Country r : list) {
	    SelectItem si = new SelectItem(r,
		    resources.getString(String.format("%1$s.%2$s", r.getClass().getName(), r.name())));
	    result.add(si);
	}
	return result;
    }

}
