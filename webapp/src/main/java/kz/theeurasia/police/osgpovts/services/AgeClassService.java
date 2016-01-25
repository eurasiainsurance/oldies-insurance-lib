package kz.theeurasia.police.osgpovts.services;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import kz.theeurasia.services.domain.AgeClass;

@ManagedBean(eager = true)
@ApplicationScoped
public class AgeClassService {

    public AgeClass[] getAgeClasses() {
	return AgeClass.values();
    }
}
