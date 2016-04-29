package kz.theeurasia.policy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredAgeClassEnum;

@Named
@ApplicationScoped
public class InsuredAgeClassService {

    private ResourceBundle gpovts;

    @Inject
    private LocaleService localeService;

    @PostConstruct
    public void init() {
	gpovts = ResourceBundle.getBundle(Messages.BUNDLE_BASE_NAME, localeService.getLocale());
    }

    public List<InsuredAgeClassEnum> getAllItems() {
	List<InsuredAgeClassEnum> result = new ArrayList<>();
	for (InsuredAgeClassEnum r : InsuredAgeClassEnum.values())
	    result.add(r);
	return result;
    }

    public List<SelectItem> getAllItemsSI() {
	return _createSIFromList(getAllItems());
    }

    public List<InsuredAgeClassEnum> getSelectableItems() {
	List<InsuredAgeClassEnum> result = new ArrayList<>();
	for (InsuredAgeClassEnum r : InsuredAgeClassEnum.values())
	    result.add(r);
	return result;
    }

    public List<SelectItem> getSelectableItemsSI() {
	return _createSIFromList(getSelectableItems());
    }

    private List<SelectItem> _createSIFromList(List<InsuredAgeClassEnum> list) {
	List<SelectItem> result = new ArrayList<>();
	for (InsuredAgeClassEnum r : list) {
	    SelectItem si = new SelectItem(r, gpovts
		    .getString(Messages.LABEL_INSURED_AGE_CLASS_PREFIX.getCode() + r.name()));
	    result.add(si);
	}
	return result;
    }
}
