package kz.theeurasia.esbdproxy.services.ejbimpl.dict.general;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.esbdproxy.domain.dict.general.CancelationReasonDict;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.CancelationReasonServiceDAO;

@Singleton
public class CancelationReasonDictServiceWS implements CancelationReasonServiceDAO {

    private List<CancelationReasonDict> all;

    @PostConstruct
    protected void init() {
	all = new ArrayList<>();
	for (CancelationReasonDict cd : CancelationReasonDict.values())
	    all.add(cd);
    }

    @Override
    public CancelationReasonDict getById(Long id) throws NotFound {
	CancelationReasonDict result = CancelationReasonDict.forId(id);
	if (result == null)
	    throw new NotFound(CancelationReasonDict.class.getSimpleName() + " not found with ID = '" + id + "'");
	return result;
    }

    @Override
    public List<CancelationReasonDict> getAll() {
	return new ArrayList<>(all);
    }
}
