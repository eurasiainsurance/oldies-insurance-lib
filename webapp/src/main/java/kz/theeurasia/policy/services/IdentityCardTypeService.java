package kz.theeurasia.policy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import kz.theeurasia.esbdproxy.domain.dict.general.IdentityCardTypeDict;
import kz.theeurasia.esbdproxy.services.general.IdentityCardTypeServiceDAO;
import kz.theeurasia.policy.view.GlobalMessageBundleCode;

@ManagedBean
@ApplicationScoped
public class IdentityCardTypeService {

    @ManagedProperty("#{glb}")
    private ResourceBundle glb;

    @EJB
    private IdentityCardTypeServiceDAO identityCardTypeServiceDAO;

    public List<IdentityCardTypeDict> getAllItems() {
	return identityCardTypeServiceDAO.getAll();
    }

    public List<SelectItem> getAllItemsSI() {
	return _createSIFromList(getAllItems());
    }

    public List<IdentityCardTypeDict> getSelectableItems() {
	return identityCardTypeServiceDAO.getAll();
    }

    public List<SelectItem> getSelectableItemsSI() {
	return _createSIFromList(getSelectableItems());
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
