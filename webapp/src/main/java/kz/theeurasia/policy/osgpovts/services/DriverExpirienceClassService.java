package kz.theeurasia.policy.osgpovts.services;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import kz.theeurasia.services.domain.osgpovts.DriverExpirienceClass;

@ManagedBean(eager = true)
@ApplicationScoped
public class DriverExpirienceClassService {

    public DriverExpirienceClass[] getDriverExpirienceClasses() {
	return DriverExpirienceClass.values();
    }
}
