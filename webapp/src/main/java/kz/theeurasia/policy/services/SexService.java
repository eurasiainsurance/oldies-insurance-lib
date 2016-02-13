package kz.theeurasia.policy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import kz.theeurasia.esbdproxy.domain.dict.general.SexDict;
import kz.theeurasia.esbdproxy.services.general.SexServiceDAO;
import kz.theeurasia.policy.view.GlobalMessageBundleCode;

@ManagedBean
@ApplicationScoped
public class SexService {

    @ManagedProperty("#{glb}")
    private ResourceBundle glb;

    @EJB
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

    // GENERATED

    public void setGlb(ResourceBundle glb) {
	this.glb = glb;
    }

}
