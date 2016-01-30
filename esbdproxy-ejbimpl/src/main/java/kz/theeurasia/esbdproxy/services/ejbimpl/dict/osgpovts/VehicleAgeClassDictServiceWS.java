package kz.theeurasia.esbdproxy.services.ejbimpl.dict.osgpovts;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleAgeClassDict;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleAgeClassServiceDAO;

@Singleton
public class VehicleAgeClassDictServiceWS implements VehicleAgeClassServiceDAO {

    private List<VehicleAgeClassDict> all;

    @PostConstruct
    protected void init() {
	all = new ArrayList<>();
	for (VehicleAgeClassDict cd : VehicleAgeClassDict.values())
	    all.add(cd);
    }

    @Override
    public VehicleAgeClassDict getById(Long id) throws NotFound {
	VehicleAgeClassDict result = VehicleAgeClassDict.forId(id);
	if (result == null)
	    throw new NotFound(VehicleAgeClassDict.class.getSimpleName() + " not found with ID = '" + id + "'");
	return result;
    }

    @Override
    public List<VehicleAgeClassDict> getAll() {
	return all;
    }

}
