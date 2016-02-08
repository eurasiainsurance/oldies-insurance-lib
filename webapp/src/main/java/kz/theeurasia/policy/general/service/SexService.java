package kz.theeurasia.policy.general.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import kz.theeurasia.esbdproxy.domain.dict.general.SexDict;
import kz.theeurasia.policy.GlobalMessageBundleCode;

@ManagedBean
@ApplicationScoped
public class SexService {

    @ManagedProperty("#{glb}")
    private ResourceBundle glb;

    public List<SexDict> getAllItems() {
	List<SexDict> result = new ArrayList<>();
	for (SexDict r : SexDict.values())
	    result.add(r);
	return result;
    }

    public List<SexDict> getValidItems() {
	List<SexDict> result = new ArrayList<>();
	for (SexDict r : SexDict.values())
	    if (!r.equals(SexDict.UNSPECIFIED))
		result.add(r);
	return result;
    }

    public List<SelectItem> getValidItemsSI() {
	List<SexDict> validItems = getValidItems();
	List<SelectItem> result = new ArrayList<>();
	for (SexDict r : validItems) {
	    SelectItem si = new SelectItem(r,
		    glb.getString(GlobalMessageBundleCode.LABEL_SI_SEX_PREFIX.getMessageBundleCode() + r.name()));
	    result.add(si);
	}
	return result;
    }

    // GENERATED

    public void setGlb(ResourceBundle glb) {
	this.glb = glb;
    }

}
