package kz.theeurasia.esbdproxy.services.ejbimpl.osgpovts;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import kz.theeurasia.esbdproxy.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.ejbimpl.ESBDServiceWS;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleClassServiceDAO;

@Stateless
public class VehicleClassServiceWS extends ESBDServiceWS implements VehicleClassServiceDAO {

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
	    throw new NotFound();
	return result;
    }

    @Override
    public List<VehicleClassDict> getAll() {
	return all;
    }

}
