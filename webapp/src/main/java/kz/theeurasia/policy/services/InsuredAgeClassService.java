package kz.theeurasia.policy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredAgeClassEnum;
import kz.theeurasia.policy.view.MessageBundleCode;

@ManagedBean
@ApplicationScoped
public class InsuredAgeClassService {

    @ManagedProperty("#{gpovts}")
    private ResourceBundle gpovts;

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
	    SelectItem si = new SelectItem(r,
		    gpovts.getString(
			    MessageBundleCode.LABEL_INSURED_AGE_CLASS_PREFIX.getMessageBundleCode() + r.name()));
	    result.add(si);
	}
	return result;
    }

    // GENERATED

    public void setGpovts(ResourceBundle gpovts) {
	this.gpovts = gpovts;
    }

}
