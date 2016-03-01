package kz.theeurasia.policy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import kz.theeurasia.esbdproxy.domain.dict.general.IdentityCardTypeDict;
import kz.theeurasia.esbdproxy.services.general.IdentityCardTypeServiceDAO;
import kz.theeurasia.policy.view.GlobalMessageBundleCode;

@Named
@ApplicationScoped
public class IdentityCardTypeService {

    @Inject
    private ResourceBundle glb;

    @Inject
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
	    SelectItem si = new SelectItem(r, glb.getString(
		    GlobalMessageBundleCode.LABEL_SI_IDENTITY_CARD_TYPE_PREFIX.getMessageBundleCode() + r.name()));
	    result.add(si);
	}
	return result;
    }
}
