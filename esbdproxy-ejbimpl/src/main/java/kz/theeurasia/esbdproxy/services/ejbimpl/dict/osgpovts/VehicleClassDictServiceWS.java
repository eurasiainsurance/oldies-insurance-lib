package kz.theeurasia.esbdproxy.services.ejbimpl.dict.osgpovts;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleClassServiceDAO;

@Singleton
public class VehicleClassDictServiceWS
	implements VehicleClassServiceDAO {

    private List<VehicleClassDict> all;

    @PostConstruct
    protected void init() {
	all = new ArrayList<>();
	for (VehicleClassDict cd : VehicleClassDict.values())
	    all.add(cd);
    }

    @Override
    public VehicleClassDict getById(Long id) throws NotFound {
	VehicleClassDict result = VehicleClassDict.forId(id);
	if (result == null)
	    throw new NotFound("Not found with ID = '" + id + "'");
	return result;
    }

    @Override
    public List<VehicleClassDict> getAll() {
	return all;
    }

}
