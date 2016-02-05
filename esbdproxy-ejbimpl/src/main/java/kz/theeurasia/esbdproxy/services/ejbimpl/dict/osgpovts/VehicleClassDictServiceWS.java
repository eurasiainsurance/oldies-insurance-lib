package kz.theeurasia.esbdproxy.services.ejbimpl.dict.osgpovts;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleClassServiceDAO;

@Singleton
public class VehicleClassDictServiceWS implements VehicleClassServiceDAO {

    private List<VehicleClassDict> all;
    private List<VehicleClassDict> applicableForOSGPOVTS;

    @PostConstruct
    protected void init() {
	all = new ArrayList<>();
	applicableForOSGPOVTS = new ArrayList<>();
	for (VehicleClassDict cd : VehicleClassDict.values()) {
	    all.add(cd);
	    if (cd.isApplicableForOSGPOVTS())
		applicableForOSGPOVTS.add(cd);
	}

    }

    @Override
    public VehicleClassDict getById(Long id) throws NotFound {
	if (id == null)
	    throw new InvalidParameterException("ID must be not null and greater than zero");
	VehicleClassDict result = VehicleClassDict.forId(id);
	if (result == null)
	    throw new NotFound(VehicleClassDict.class.getSimpleName() + " not found with ID = '" + id + "'");
	return result;
    }

    @Override
    public List<VehicleClassDict> getAll() {
	return new ArrayList<>(all);
    }

    @Override
    public List<VehicleClassDict> getApplicableForOSGPOVTS() {
	return new ArrayList<>(applicableForOSGPOVTS);
    }
}
