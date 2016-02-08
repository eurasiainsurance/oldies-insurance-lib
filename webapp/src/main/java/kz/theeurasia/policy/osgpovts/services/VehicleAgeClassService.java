package kz.theeurasia.policy.osgpovts.services;

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
import kz.theeurasia.policy.osgpovts.MessageBundleCode;

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

    public List<VehicleAgeClassDict> getValidItems() {
	return vehicleAgeClassServiceDAO.getApplicableForOSGPOVTS();
    }

    public List<SelectItem> getValidItemsSI() {
	List<VehicleAgeClassDict> validItems = getValidItems();
	List<SelectItem> result = new ArrayList<>();
	for (VehicleAgeClassDict r : validItems) {
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
