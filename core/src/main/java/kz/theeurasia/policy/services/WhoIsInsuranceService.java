package kz.theeurasia.policy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import kz.theeurasia.policy.domain.WhoIsInsurant;

@Named
@ApplicationScoped
public class WhoIsInsuranceService {

    private ResourceBundle msg;

    @PostConstruct
    public void init() {
	msg = ResourceBundle.getBundle(Messages.BUNDLE_BASE_NAME);
    }

    public List<WhoIsInsurant> getAllItems() {
	List<WhoIsInsurant> res = new ArrayList<>();
	for (WhoIsInsurant i : WhoIsInsurant.values())
	    res.add(i);
	return res;
    }

    public List<SelectItem> getAllItemsSI() {
	return _createSIFromList(getAllItems());
    }

    public List<WhoIsInsurant> getSelectableItems() {
	List<WhoIsInsurant> r = getAllItems();
	r.remove(WhoIsInsurant.UNSPECIFIED);
	return r;
    }

    public List<SelectItem> getSelectableItemsSI() {
	return _createSIFromList(getSelectableItems());
    }

    private List<SelectItem> _createSIFromList(List<WhoIsInsurant> list) {
	List<SelectItem> result = new ArrayList<>();
	for (WhoIsInsurant r : list) {
	    SelectItem si = new SelectItem(r,
		    msg.getString(Messages.LABEL_SI_WHO_IS_INSURANT_PREFIX.getCode() + r.name()));
	    result.add(si);
	}
	return result;
    }
}
