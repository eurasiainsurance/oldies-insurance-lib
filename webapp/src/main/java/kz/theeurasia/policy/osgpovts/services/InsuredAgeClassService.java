package kz.theeurasia.policy.osgpovts.services;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import kz.theeurasia.services.domain.osgpovts.InsuredAgeClass;

@ManagedBean(eager = true)
@ApplicationScoped
public class InsuredAgeClassService {

    public InsuredAgeClass[] getInsuredAgeClasses() {
	return InsuredAgeClass.values();
    }
}
