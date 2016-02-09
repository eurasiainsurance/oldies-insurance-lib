package kz.theeurasia.policy.general.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import kz.theeurasia.esbdproxy.domain.dict.general.IdentityCardTypeDict;
import kz.theeurasia.policy.GlobalMessageBundleCode;

@ManagedBean
@ApplicationScoped
public class IdentityCardTypeService {

    @ManagedProperty("#{glb}")
    private ResourceBundle glb;

    public List<IdentityCardTypeDict> getAllItems() {
	List<IdentityCardTypeDict> result = new ArrayList<>();
	for (IdentityCardTypeDict r : IdentityCardTypeDict.values())
	    result.add(r);
	return result;
    }

    public List<SelectItem> getAllItemsSI() {
	return _createSIFromList(getAllItems());
    }

    public List<IdentityCardTypeDict> getValidItems() {
	List<IdentityCardTypeDict> result = new ArrayList<>();
	for (IdentityCardTypeDict r : IdentityCardTypeDict.values())
	    if (!r.equals(IdentityCardTypeDict.UNSPECIFIED))
		result.add(r);
	return result;
    }

    public List<SelectItem> getValidItemsSI() {
	return _createSIFromList(getValidItems());
    }

    private List<SelectItem> _createSIFromList(List<IdentityCardTypeDict> list) {
	List<SelectItem> result = new ArrayList<>();
	for (IdentityCardTypeDict r : list) {
	    SelectItem si = new SelectItem(r,
		    glb.getString(GlobalMessageBundleCode.LABEL_SI_IDENTITY_CARD_TYPE_PREFIX.getMessageBundleCode()
			    + r.name()));
	    result.add(si);
	}
	return result;
    }

    // GENERATED

    public void setGlb(ResourceBundle glb) {
	this.glb = glb;
    }

}
