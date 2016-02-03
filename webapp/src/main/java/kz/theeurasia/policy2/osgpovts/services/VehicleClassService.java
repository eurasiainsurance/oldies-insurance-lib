package kz.theeurasia.policy2.osgpovts.services;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleClassServiceDAO;

@ManagedBean
@ApplicationScoped
public class VehicleClassService {

    @EJB
    private VehicleClassServiceDAO vehicleClassServiceDAO;

    public List<VehicleClassDict> getAllItems() {
	return vehicleClassServiceDAO.getAll();
    }

    public List<VehicleClassDict> getValidItems() {
	return vehicleClassServiceDAO.getApplicableForOSGPOVTS();
    }
}
