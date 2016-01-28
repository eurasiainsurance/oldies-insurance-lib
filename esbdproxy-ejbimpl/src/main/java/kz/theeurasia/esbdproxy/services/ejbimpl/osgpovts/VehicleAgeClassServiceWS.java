package kz.theeurasia.esbdproxy.services.ejbimpl.osgpovts;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import kz.theeurasia.esbdproxy.dict.osgpovts.VehicleAgeClassDict;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.ejbimpl.ESBDServiceWS;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleAgeClassServiceDAO;

@Stateless
public class VehicleAgeClassServiceWS extends ESBDServiceWS implements VehicleAgeClassServiceDAO {

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
	    throw new NotFound();
	return result;
    }

    @Override
    public List<VehicleAgeClassDict> getAll() {
	return all;
    }

}
