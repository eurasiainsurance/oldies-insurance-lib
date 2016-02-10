package kz.theeurasia.esbdproxy.services.ejbimpl.dict.general;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.esbdproxy.domain.dict.general.KZCityDict;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.KZCityServiceDAO;

@Singleton
public class KZCityDictServiceWS implements KZCityServiceDAO {

    private List<KZCityDict> all = new ArrayList<>();

    @PostConstruct
    protected void init() {
	for (KZCityDict cd : KZCityDict.values())
	    all.add(cd);
    }

    @Override
    public KZCityDict getById(Long id) throws NotFound {
	if (id == null)
	    throw new InvalidParameterException("ID must be not null");
	KZCityDict result = KZCityDict.forId(id);
	if (result == null)
	    throw new NotFound(KZCityDict.class.getSimpleName() + " not found with ID = '" + id + "'");
	return result;
    }

    @Override
    public List<KZCityDict> getAll() {
	return new ArrayList<>(all);
    }

    @Override
    public List<KZCityDict> getBySearchPattern(String pattern) {
	List<KZCityDict> res = new ArrayList<>();
	Pattern p = null;
	try {
	    p = Pattern.compile(".*" + pattern.toLowerCase() + ".*", Pattern.CASE_INSENSITIVE);
	} catch (PatternSyntaxException e1) {
	}
	for (KZCityDict e : all) {
	    if (p != null && (p.matcher(e.getRusname().toLowerCase()).matches()
		    || p.matcher(e.getKazname().toLowerCase()).matches()
		    || p.matcher(e.name().toLowerCase()).matches())) {
		res.add(e);
		continue;
	    }
	}
	return res;
    }
}
