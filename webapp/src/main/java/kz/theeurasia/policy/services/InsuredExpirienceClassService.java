package kz.theeurasia.policy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredExpirienceClassEnum;
import kz.theeurasia.policy.view.MessageBundleCode;

@ManagedBean
@ApplicationScoped
public class InsuredExpirienceClassService {

    @ManagedProperty("#{gpovts}")
    private ResourceBundle gpovts;

    public List<InsuredExpirienceClassEnum> getAllItems() {
	List<InsuredExpirienceClassEnum> result = new ArrayList<>();
	for (InsuredExpirienceClassEnum r : InsuredExpirienceClassEnum.values())
	    result.add(r);
	return result;
    }

    public List<SelectItem> getAllItemsSI() {
	return _createSIFromList(getAllItems());
    }

    public List<InsuredExpirienceClassEnum> getValidItems() {
	List<InsuredExpirienceClassEnum> result = new ArrayList<>();
	for (InsuredExpirienceClassEnum r : InsuredExpirienceClassEnum.values())
	    if (!r.equals(InsuredExpirienceClassEnum.UNSPECIFIED))
		result.add(r);
	return result;
    }

    public List<SelectItem> getValidItemsSI() {
	return _createSIFromList(getValidItems());
    }

    private List<SelectItem> _createSIFromList(List<InsuredExpirienceClassEnum> list) {
	List<SelectItem> result = new ArrayList<>();
	for (InsuredExpirienceClassEnum r : list) {
	    SelectItem si = new SelectItem(r,
		    gpovts.getString(
			    MessageBundleCode.LABEL_INSURED_EXPIRIENCE_CLASS_PREFIX.getMessageBundleCode() + r.name()));
	    result.add(si);
	}
	return result;
    }

    // GENERATED

    public void setGpovts(ResourceBundle gpovts) {
	this.gpovts = gpovts;
    }

}
