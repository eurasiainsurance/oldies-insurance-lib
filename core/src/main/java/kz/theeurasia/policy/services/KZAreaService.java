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

@Named("countryRegionService")
@ApplicationScoped
public class KZAreaService {

    @Inject
    private LocaleService localeService;

    private ResourceBundle msg;

    @PostConstruct
    public void init() {
	msg = ResourceBundle.getBundle(KZArea.BUNDLE_BASENAME, localeService.getLocale());
    }

    public List<KZArea> getAllItems() {
	return CollectionUtils.toList(KZArea.values());
    }

    public List<SelectItem> getAllItemsSI() {
	return _createSIFromList(getAllItems());
    }

    public List<KZArea> getSelectableItems() {
	return new ArrayList<>(getAllItems());
    }

    public List<SelectItem> getSelectableItemsSI() {
	return _createSIFromList(getSelectableItems());
    }

    private List<SelectItem> _createSIFromList(List<KZArea> list) {
	List<SelectItem> result = new ArrayList<>();
	for (KZArea r : list) {
	    SelectItem si = new SelectItem(r, msg.getString(String.format("%s.%s", r.getClass().getName(), r.name())));
	    result.add(si);
	}
	return result;
    }
}
