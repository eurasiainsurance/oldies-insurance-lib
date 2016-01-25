package kz.theeurasia.police.osgpovts.services;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import kz.theeurasia.services.domain.VehicleClass;

@ManagedBean(eager = true)
@ApplicationScoped
public class VehicleClassService {

    public VehicleClass[] getVehicleClasses() {
	return VehicleClass.values();
    }
}
