package kz.theeurasia.esbdproxy.services.ejbimpl.dict.general;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.esbdproxy.domain.dict.general.EconomicSectorDict;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.EconomicSectorServiceDAO;

@Singleton
public class EconomicSectorDictServiceWS implements EconomicSectorServiceDAO {

    private List<EconomicSectorDict> all;

    @PostConstruct
    protected void init() {
	all = new ArrayList<>();
	for (EconomicSectorDict cd : EconomicSectorDict.values())
	    all.add(cd);
    }

    @Override
    public EconomicSectorDict getById(Long id) throws NotFound {
	EconomicSectorDict result = EconomicSectorDict.forId(id);
	if (result == null)
	    throw new NotFound(EconomicSectorDict.class.getSimpleName() + " not found with ID = '" + id + "'");
	return result;
    }

    @Override
    public List<EconomicSectorDict> getAll() {
	return new ArrayList<>(all);
    }

}
