package kz.theeurasia.policy2.osgpovts.services;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredAgeClassEnum;

@ManagedBean
@ApplicationScoped
public class InsuredAgeClassService {
    public List<InsuredAgeClassEnum> getAllItems() {
	List<InsuredAgeClassEnum> result = new ArrayList<>();
	for (InsuredAgeClassEnum r : InsuredAgeClassEnum.values())
	    result.add(r);
	return result;
    }

    public List<InsuredAgeClassEnum> getValidItems() {
	List<InsuredAgeClassEnum> result = new ArrayList<>();
	for (InsuredAgeClassEnum r : InsuredAgeClassEnum.values())
	    if (!r.equals(InsuredAgeClassEnum.UNSPECIFIED))
		result.add(r);
	return result;
    }
}
