package kz.theeurasia.policy.osgpovts.services;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import kz.theeurasia.esbdproxy.domain.dict.general.SexDict;

@ManagedBean
@ApplicationScoped
public class SexService {
    public List<SexDict> getAllItems() {
	List<SexDict> result = new ArrayList<>();
	for (SexDict r : SexDict.values())
	    result.add(r);
	return result;
    }

    public List<SexDict> getValidItems() {
	List<SexDict> result = new ArrayList<>();
	for (SexDict r : SexDict.values())
	    if (!r.equals(SexDict.UNSPECIFIED))
		result.add(r);
	return result;
    }
}
