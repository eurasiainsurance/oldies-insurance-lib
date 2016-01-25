package kz.theeurasia.police.osgpovts.services;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import kz.theeurasia.services.domain.VehicleAgeClass;

@ManagedBean(eager = true)
@ApplicationScoped
public class VehicleAgeClassService {

    public VehicleAgeClass[] getVehicleAgeClasses() {
	return VehicleAgeClass.values();
    }
}
