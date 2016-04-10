
package kz.theeurasia.policy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;

@Named("kzCityService")
@ApplicationScoped
public class KZCityService {

    @Inject
    private LocaleService localeService;

    private ResourceBundle kzlibMessages;

    @PostConstruct
    public void init() {
	kzlibMessages = ResourceBundle.getBundle(KZCity.BUNDLE_BASENAME, localeService.getLocale());
    }

    public List<KZCity> getAllItems() {
	return CollectionUtils.toList(KZCity.values());
    }

    public List<SelectItem> getAllItemsSI() {
	return _createSIFromList(getAllItems());
    }

    public List<KZCity> getSelectableItems() {
	return new ArrayList<>(getAllItems());
    }

    public List<SelectItem> getSelectableItemsSI() {
	return _createSIFromList(getSelectableItems());
    }

    public List<KZCity> selectableItemsByArea(KZArea area) {
	List<KZCity> result = new ArrayList<>();
	for (KZCity city : KZCity.values())
	    if (area == null || city.getArea().equals(area))
		result.add(city);
	return result;
    }

    public List<SelectItem> regionalItemsByAreaSI(KZArea area) {
	return _createSIFromList(regionalItemsByArea(area));
    }

    public List<KZCity> regionalItemsByArea(KZArea area) {
	List<KZCity> result = new ArrayList<>();
	for (KZCity city : KZCity.values()) {
	    if (city.getArea() == null) // TODO плохой код. Сделано чтобы OTHER
					// не попадал в список. Исправить
		continue;
	    if (!isRegional(city))
		continue;
	    if (area == null || city.getArea().equals(area))
		result.add(city);
	}
	return result;
    }

    public List<SelectItem> selectableItemsByAreaSI(KZArea area) {
	return _createSIFromList(selectableItemsByArea(area));
    }

    private List<SelectItem> _createSIFromList(List<KZCity> list) {
	List<SelectItem> result = new ArrayList<>();
	for (KZCity r : list) {
	    SelectItem si = new SelectItem(r,
		    kzlibMessages.getString(String.format("%1$s.%2$s", r.getClass().getName(), r.name())));
	    result.add(si);
	}
	return result;
    }

    private boolean isRegional(KZCity city) {
	if (city == null || city.getType() == null)
	    return false;
	switch (city.getType()) {
	case MAJOR:
	case REGIONAL_CENTER:
	case REGIONAL_SUBORDINATION:
	    return true;
	default:
	}
	return false;
    }

}
