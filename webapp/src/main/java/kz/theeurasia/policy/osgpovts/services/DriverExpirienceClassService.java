package kz.theeurasia.policy.osgpovts.services;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredExpirienceClassEnum;

@ManagedBean(eager = true)
@ApplicationScoped
public class DriverExpirienceClassService {

    public InsuredExpirienceClassEnum[] getDriverExpirienceClasses() {
	return InsuredExpirienceClassEnum.values();
    }
}
