package kz.theeurasia.esbdproxy.services.ejbimpl.dict.osgpovts;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuredAgeExpirienceClassDict;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.osgpovts.InsuredAgeExpirienceClassServiceDAO;

@Singleton
public class InsuredAgeExpirienceClassDictServiceWS
	implements InsuredAgeExpirienceClassServiceDAO {

    private List<InsuredAgeExpirienceClassDict> all;

    @PostConstruct
    protected void init() {
	all = new ArrayList<>();
	for (InsuredAgeExpirienceClassDict cd : InsuredAgeExpirienceClassDict.values())
	    all.add(cd);
    }

    @Override
    public InsuredAgeExpirienceClassDict getById(Long id) throws NotFound {
	InsuredAgeExpirienceClassDict result = InsuredAgeExpirienceClassDict.forId(id);
	if (result == null)
	    throw new NotFound(
		    InsuredAgeExpirienceClassDict.class.getSimpleName() + " not found with ID = '" + id + "'");
	return result;
    }

    @Override
    public List<InsuredAgeExpirienceClassDict> getAll() {
	return all;
    }

}
