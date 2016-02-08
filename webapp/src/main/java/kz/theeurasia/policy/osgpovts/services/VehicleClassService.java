package kz.theeurasia.policy.osgpovts.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleClassServiceDAO;
import kz.theeurasia.policy.osgpovts.MessageBundleCode;

@ManagedBean
@ApplicationScoped
public class VehicleClassService {

    @ManagedProperty("#{gpovts}")
    private ResourceBundle gpovts;

    @EJB
    private VehicleClassServiceDAO vehicleClassServiceDAO;

    public List<VehicleClassDict> getAllItems() {
	return vehicleClassServiceDAO.getAll();
    }

    public List<VehicleClassDict> getValidItems() {
	return vehicleClassServiceDAO.getApplicableForOSGPOVTS();
    }

    public List<SelectItem> getValidItemsSI() {
	List<VehicleClassDict> validItems = getValidItems();
	List<SelectItem> result = new ArrayList<>();
	for (VehicleClassDict r : validItems) {
	    SelectItem si = new SelectItem(r,
		    gpovts.getString(MessageBundleCode.LABEL_VEHICLE_CLASS_PREFIX.getMessageBundleCode() + r.name()));
	    result.add(si);
	}
	return result;
    }

    // GENERATED

    public void setGpovts(ResourceBundle gpovts) {
	this.gpovts = gpovts;
    }
}
