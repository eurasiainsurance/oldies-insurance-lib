package kz.theeurasia.esbdproxy.services.ejbimpl.dict;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.esbdproxy.domain.dict.SexDict;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.SexServiceDAO;

@Singleton
public class SexDictServiceWS implements SexServiceDAO {

    private List<SexDict> all;

    @PostConstruct
    protected void init() {
	all = new ArrayList<>();
	for (SexDict cd : SexDict.values())
	    all.add(cd);
    }

    @Override
    public SexDict getById(Long id) throws NotFound {
	SexDict result = SexDict.forId(id);
	if (result == null)
	    throw new NotFound("Not found with ID = '" + id + "'");
	return result;
    }

    @Override
    public List<SexDict> getAll() {
	return all;
    }

}
