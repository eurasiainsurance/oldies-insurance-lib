package kz.theeurasia.esbdproxy.services.ejbimpl.dict.osgpovts;

import java.security.InvalidParameterException;
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
	if (id == null)
	    throw new InvalidParameterException("ID must be not null");
	VehicleAgeClassDict result = VehicleAgeClassDict.forId(id);
	if (result == null)
	    throw new NotFound(VehicleAgeClassDict.class.getSimpleName() + " not found with ID = '" + id + "'");
	return result;
    }

    @Override
    public List<VehicleAgeClassDict> getAll() {
	return new ArrayList<>(all);
    }

    @Override
    public List<VehicleAgeClassDict> getApplicableForOSGPOVTS() {
	List<VehicleAgeClassDict> res = new ArrayList<>();
	res.add(VehicleAgeClassDict.OVER7);
	res.add(VehicleAgeClassDict.UNDER7);
	return res;
    }
}
