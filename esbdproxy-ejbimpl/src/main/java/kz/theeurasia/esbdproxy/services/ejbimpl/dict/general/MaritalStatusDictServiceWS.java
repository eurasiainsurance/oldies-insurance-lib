package kz.theeurasia.esbdproxy.services.ejbimpl.dict.general;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.esbdproxy.domain.dict.general.MaritalStatusDict;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.MaritalStatusServiceDAO;

@Singleton
public class MaritalStatusDictServiceWS implements MaritalStatusServiceDAO {

    private List<MaritalStatusDict> all;

    @PostConstruct
    protected void init() {
	all = new ArrayList<>();
	for (MaritalStatusDict cd : MaritalStatusDict.values())
	    all.add(cd);
    }

    @Override
    public MaritalStatusDict getById(Long id) throws NotFound {
	if (id == null)
	    throw new InvalidParameterException("ID must be not null");
	MaritalStatusDict result = MaritalStatusDict.forId(id);
	if (result == null)
	    throw new NotFound(MaritalStatusDict.class.getSimpleName() + " not found with ID = '" + id + "'");
	return result;
    }

    @Override
    public List<MaritalStatusDict> getAll() {
	return new ArrayList<>(all);
    }

}
