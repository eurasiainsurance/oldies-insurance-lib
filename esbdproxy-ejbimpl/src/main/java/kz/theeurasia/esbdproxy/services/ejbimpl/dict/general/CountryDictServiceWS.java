package kz.theeurasia.esbdproxy.services.ejbimpl.dict.general;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryDict;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.CountryServiceDAO;

@Singleton
public class CountryDictServiceWS implements CountryServiceDAO {

    private List<CountryDict> all = new ArrayList<>();
    private List<CountryDict> selectable = new ArrayList<>();

    @PostConstruct
    protected void init() {
	for (CountryDict cd : CountryDict.values()) {
	    all.add(cd);
	    if (cd.isSelectable())
		selectable.add(cd);
	}
    }

    @Override
    public CountryDict getById(Long id) throws NotFound {
	if (id == null)
	    throw new InvalidParameterException("ID must be not null");
	CountryDict result = CountryDict.forId(id);
	if (result == null)
	    throw new NotFound(CountryDict.class.getSimpleName() + " not found with ID = '" + id + "'");
	return result;
    }

    @Override
    public List<CountryDict> getAll() {
	return new ArrayList<>(all);
    }

    @Override
    public List<CountryDict> getSelectable() {
	return new ArrayList<>(selectable);
    }

    @Override
    public List<CountryDict> getBySearchPattern(String pattern) {
	List<CountryDict> res = new ArrayList<>();
	Pattern p = null;
	try {
	    p = Pattern.compile(".*" + pattern.toLowerCase() + ".*", Pattern.CASE_INSENSITIVE);
	} catch (PatternSyntaxException e1) {
	}
	for (CountryDict e : all) {
	    if (p != null && (p.matcher(e.getRusname().toLowerCase()).matches()
		    || p.matcher(e.getEngname().toLowerCase()).matches()
		    || p.matcher(e.name().toLowerCase()).matches())) {
		res.add(e);
		continue;
	    }
	}
	return res;
    }

    @Override
    public CountryDict getOneByName(String name) throws NotFound {
	for (CountryDict e : all) {
	    if (e.getRusname().equals(name)) {
		return e;
	    }
	}
	throw new NotFound(CountryDict.class.getSimpleName() + " not found with NAME = '" + name + "'");
    }

}
