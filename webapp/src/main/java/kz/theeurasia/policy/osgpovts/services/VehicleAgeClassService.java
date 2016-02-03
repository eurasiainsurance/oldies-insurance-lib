package kz.theeurasia.policy.osgpovts.services;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleAgeClassDict;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleAgeClassServiceDAO;

@ManagedBean
@ApplicationScoped
public class VehicleAgeClassService {

    @EJB
    private VehicleAgeClassServiceDAO vehicleAgeClassServiceDAO;

    public List<VehicleAgeClassDict> getAllItems() {
	return vehicleAgeClassServiceDAO.getAll();
    }

    public List<VehicleAgeClassDict> getValidItems() {
	return vehicleAgeClassServiceDAO.getApplicableForOSGPOVTS();
    }
}
