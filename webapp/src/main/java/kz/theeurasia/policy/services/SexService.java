package kz.theeurasia.policy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import kz.theeurasia.esbdproxy.domain.dict.general.SexDict;
import kz.theeurasia.esbdproxy.services.general.SexServiceDAO;
import kz.theeurasia.policy.view.GlobalMessageBundleCode;

@Named
@ApplicationScoped
public class SexService {

    private ResourceBundle glb;

    @PostConstruct
    public void init() {
	glb = ResourceBundle.getBundle(GlobalMessageBundleCode.BUNDLE_BASE_NAME);
    }

    @Inject
    private SexServiceDAO sexServiceDAO;

    public List<SexDict> getAllItems() {
	return sexServiceDAO.getAll();
    }

    public List<SelectItem> getAllItemsSI() {
	return _createSIFromList(getAllItems());
    }

    public List<SexDict> getSelectableItems() {
	List<SexDict> r = sexServiceDAO.getAll();
	r.remove(SexDict.UNSPECIFIED);
	return r;
    }

    public List<SelectItem> getSelectableItemsSI() {
	return _createSIFromList(getSelectableItems());
    }

    private List<SelectItem> _createSIFromList(List<SexDict> list) {
	List<SelectItem> result = new ArrayList<>();
	for (SexDict r : list) {
	    SelectItem si = new SelectItem(r,
		    glb.getString(GlobalMessageBundleCode.LABEL_SI_SEX_PREFIX.getMessageBundleCode() + r.name()));
	    result.add(si);
	}
	return result;
    }
}
