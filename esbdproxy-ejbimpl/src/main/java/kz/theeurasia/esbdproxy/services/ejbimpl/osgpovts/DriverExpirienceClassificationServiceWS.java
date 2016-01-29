package kz.theeurasia.esbdproxy.services.ejbimpl.osgpovts;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuredDriverExpirienceClassComplexDict;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.ejbimpl.ESBDServiceWS;
import kz.theeurasia.esbdproxy.services.osgpovts.DriverExpirienceClassificationServiceDAO;

@Singleton
public class DriverExpirienceClassificationServiceWS extends ESBDServiceWS
	implements DriverExpirienceClassificationServiceDAO {

    private List<InsuredDriverExpirienceClassComplexDict> all;

    @PostConstruct
    protected void init() {
	all = new ArrayList<>();
	for (InsuredDriverExpirienceClassComplexDict cd : InsuredDriverExpirienceClassComplexDict.values())
	    all.add(cd);
    }

    @Override
    public InsuredDriverExpirienceClassComplexDict getById(Long id) throws NotFound {
	InsuredDriverExpirienceClassComplexDict result = InsuredDriverExpirienceClassComplexDict.forId(id);
	if (result == null)
	    throw new NotFound("Not found with ID = '" + id + "'");
	return result;
    }

    @Override
    public List<InsuredDriverExpirienceClassComplexDict> getAll() {
	return all;
    }

}
