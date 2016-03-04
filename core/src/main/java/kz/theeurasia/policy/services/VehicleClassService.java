package kz.theeurasia.policy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleClassServiceDAO;

@Named
@ApplicationScoped
public class VehicleClassService {

    private ResourceBundle msg;

    @PostConstruct
    public void init() {
	msg = ResourceBundle.getBundle(Messages.BUNDLE_BASE_NAME);
    }

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
	    SelectItem si = new SelectItem(r, msg.getString(Messages.LABEL_VEHICLE_CLASS_PREFIX.getCode() + r.name()));
	    result.add(si);
	}
	return result;
    }
}
