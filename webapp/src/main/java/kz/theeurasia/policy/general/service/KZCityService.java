package kz.theeurasia.policy.general.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import kz.theeurasia.policy.general.domain.KZCity;

@ManagedBean(name = "kzCityService")
@ApplicationScoped
public class KZCityService {

    public List<KZCity> getAllItems() {
	List<KZCity> result = new ArrayList<>();
	for (KZCity r : KZCity.values())
	    result.add(r);
	return result;
    }

    public List<KZCity> getValidItems() {
	return getAllItems();
    }

    public List<SelectItem> getAllItemsSI() {
	return _createSIFromList(getAllItems());
    }

    public List<SelectItem> getValidItemsSI() {
	return _createSIFromList(getValidItems());
    }

    private List<SelectItem> _createSIFromList(List<KZCity> list) {
	List<SelectItem> result = new ArrayList<>();
	for (KZCity r : list) {
	    SelectItem si = new SelectItem(r, r.getRusname());
	    result.add(si);
	}
	return result;
    }

    public List<String> getCitiNamesByQuery(String query) {
	List<String> res = new ArrayList<>();
	Pattern p = null;
	try {
	    p = Pattern.compile(".*" + query.toLowerCase() + ".*", Pattern.CASE_INSENSITIVE);
	} catch (PatternSyntaxException e1) {
	}
	for (KZCity e : KZCity.values()) {
	    if (p != null && (p.matcher(e.getRusname().toLowerCase()).matches()
		    || p.matcher(e.getKazname().toLowerCase()).matches())) {
		res.add(e.getRusname());
		continue;
	    }
	}
	return res;
    }
}
