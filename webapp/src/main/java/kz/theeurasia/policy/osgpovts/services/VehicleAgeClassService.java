package kz.theeurasia.policy.osgpovts.services;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import kz.theeurasia.services.domain.osgpovts.VehicleAgeClass;

@ManagedBean(eager = true, name="QAZ")
@ApplicationScoped
public class VehicleAgeClassService {

    public VehicleAgeClass[] getVehicleAgeClasses() {
	return VehicleAgeClass.values();
    }
}
