package kz.theeurasia.policy.osgpovts.services;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredExpirienceClassEnum;

@ManagedBean
@ApplicationScoped
public class InsuredExpirienceClassService {
    public List<InsuredExpirienceClassEnum> getAllItems() {
	List<InsuredExpirienceClassEnum> result = new ArrayList<>();
	for (InsuredExpirienceClassEnum r : InsuredExpirienceClassEnum.values())
	    result.add(r);
	return result;
    }

    public List<InsuredExpirienceClassEnum> getValidItems() {
	List<InsuredExpirienceClassEnum> result = new ArrayList<>();
	for (InsuredExpirienceClassEnum r : InsuredExpirienceClassEnum.values())
	    if (!r.equals(InsuredExpirienceClassEnum.UNSPECIFIED))
		result.add(r);
	return result;
    }
}
