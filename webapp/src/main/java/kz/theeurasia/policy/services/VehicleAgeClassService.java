package kz.theeurasia.policy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleAgeClassDict;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleAgeClassServiceDAO;
import kz.theeurasia.policy.view.MessageBundleCode;

@ManagedBean
@ApplicationScoped
public class VehicleAgeClassService {

    @ManagedProperty("#{gpovts}")
    private ResourceBundle gpovts;

    @EJB
    private VehicleAgeClassServiceDAO vehicleAgeClassServiceDAO;

    public List<VehicleAgeClassDict> getAllItems() {
	return vehicleAgeClassServiceDAO.getAll();
    }

    public List<SelectItem> getAllItemsSI() {
	return _createSIFromList(getAllItems());
    }

    public List<VehicleAgeClassDict> getValidItems() {
	return vehicleAgeClassServiceDAO.getApplicableForOSGPOVTS();
    }

    public List<SelectItem> getValidItemsSI() {
	return _createSIFromList(getValidItems());
    }

    private List<SelectItem> _createSIFromList(List<VehicleAgeClassDict> list) {
	List<SelectItem> result = new ArrayList<>();
	for (VehicleAgeClassDict r : list) {
	    SelectItem si = new SelectItem(r,
		    gpovts.getString(
			    MessageBundleCode.LABEL_VEHICLE_AGE_CLASS_PREFIX.getMessageBundleCode() + r.name()));
	    result.add(si);
	}
	return result;
    }

    // GENERATED

    public void setGpovts(ResourceBundle gpovts) {
	this.gpovts = gpovts;
    }
}
