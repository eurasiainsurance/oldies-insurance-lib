package kz.theeurasia.policy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleClassServiceDAO;
import kz.theeurasia.policy.view.MessageBundleCode;

@Named
@ApplicationScoped
public class VehicleClassService {

    @Inject
    private ResourceBundle gpovts;

    @Inject
    private VehicleClassServiceDAO vehicleClassServiceDAO;

    public List<VehicleClassDict> getAllItems() {
	return vehicleClassServiceDAO.getAll();
    }

    public List<SelectItem> getAllItemsSI() {
	return _createSIFromList(getAllItems());
    }

    public List<VehicleClassDict> getSelectableItems() {
	return vehicleClassServiceDAO.getApplicableForOSGPOVTS();
    }

    public List<SelectItem> getSelectableItemsSI() {
	return _createSIFromList(getSelectableItems());
    }

    private List<SelectItem> _createSIFromList(List<VehicleClassDict> list) {
	List<SelectItem> result = new ArrayList<>();
	for (VehicleClassDict r : list) {
	    SelectItem si = new SelectItem(r,
		    gpovts.getString(MessageBundleCode.LABEL_VEHICLE_CLASS_PREFIX.getMessageBundleCode() + r.name()));
	    result.add(si);
	}
	return result;
    }
}
