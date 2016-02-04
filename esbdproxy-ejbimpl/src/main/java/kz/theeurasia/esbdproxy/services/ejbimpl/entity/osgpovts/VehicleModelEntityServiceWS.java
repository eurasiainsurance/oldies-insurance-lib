package kz.theeurasia.esbdproxy.services.ejbimpl.entity.osgpovts;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.ArrayOfVOITUREMODEL;
import kz.theeurasia.asb.esbd.jaxws.VOITUREMODEL;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleManufacturerEntity;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleModelEntity;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.ejbimpl.DataCoruptionException;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.general.AbstractESBDEntityServiceWS;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleManufacturerServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleModelServiceDAO;

@Singleton
public class VehicleModelEntityServiceWS extends AbstractESBDEntityServiceWS implements VehicleModelServiceDAO {

    @EJB
    private VehicleManufacturerServiceDAO vehicleManufacturerService;

    @Override
    public VehicleModelEntity getById(Long id) throws NotFound, InvalidInputParameter {
	if (id == null)
	    throw new InvalidInputParameter("ID must be not null");
	// VOITURE_MODEL_ID, NAME, VOITURE_MARK_ID
	VOITUREMODEL m = new VOITUREMODEL();
	m.setID(new Long(id).intValue());
	ArrayOfVOITUREMODEL models = getSoapService().getVoitureModels(getSessionId(), m);
	if (models == null || models.getVOITUREMODEL() == null || models.getVOITUREMODEL().isEmpty())
	    throw new NotFound(VehicleModelEntity.class.getSimpleName() + " not found with ID = '" + id + "'");
	if (models.getVOITUREMODEL().size() > 1)
	    throw new DataCoruptionException(
		    "Too many " + VehicleModelEntity.class.getSimpleName() + " ("
			    + models.getVOITUREMODEL().size() + ") with ID = '" + id + "'");
	VehicleModelEntity vehicle = new VehicleModelEntity();
	fillValues(models.getVOITUREMODEL().iterator().next(), vehicle);
	return vehicle;
    }

    @Override
    public List<VehicleModelEntity> getByName(String name) throws InvalidInputParameter {
	if (name == null || name.trim().isEmpty())
	    throw new InvalidInputParameter("'name' must be not an empty string");
	// VOITURE_MODEL_ID, NAME, VOITURE_MARK_ID
	List<VehicleModelEntity> res = new ArrayList<>();
	VOITUREMODEL m = new VOITUREMODEL();
	m.setNAME(name);
	ArrayOfVOITUREMODEL reslist = getSoapService().getVoitureModels(getSessionId(), m);
	if (reslist == null || reslist.getVOITUREMODEL() == null || reslist.getVOITUREMODEL().isEmpty())
	    return res;
	for (VOITUREMODEL source : reslist.getVOITUREMODEL()) {
	    VehicleModelEntity e = new VehicleModelEntity();
	    fillValues(source, e);
	    res.add(e);
	}
	return res;
    }

    @Override
    public List<VehicleModelEntity> getByManufacturer(VehicleManufacturerEntity manufacturer) {
	if (manufacturer == null)
	    throw new InvalidParameterException("'manufacturer' must be not a null value");
	// VOITURE_MODEL_ID, NAME, VOITURE_MARK_ID
	List<VehicleModelEntity> res = new ArrayList<>();
	VOITUREMODEL m = new VOITUREMODEL();
	m.setVOITUREMARKID(new Long(manufacturer.getId()).intValue());
	ArrayOfVOITUREMODEL reslist = getSoapService().getVoitureModels(getSessionId(), m);
	if (reslist == null || reslist.getVOITUREMODEL() == null || reslist.getVOITUREMODEL().isEmpty())
	    return res;
	for (VOITUREMODEL source : reslist.getVOITUREMODEL()) {
	    VehicleModelEntity e = new VehicleModelEntity();
	    fillValues(source, e, manufacturer);
	    res.add(e);
	}
	return res;
    }

    private void fillValues(VOITUREMODEL source, VehicleModelEntity target,
	    VehicleManufacturerEntity defaultManufacturer) {
	target.setId(source.getID());
	target.setName(source.getNAME());
	target.setManufacturer(defaultManufacturer);
    }

    private void fillValues(VOITUREMODEL source, VehicleModelEntity target) {
	target.setId(source.getID());
	target.setName(source.getNAME());
	try {
	    target.setManufacturer(vehicleManufacturerService.getById(new Long(source.getVOITUREMARKID())));
	} catch (NotFound | InvalidInputParameter e) {
	    // mandatory field
	    throw new DataCoruptionException(
		    "Error while fetching Vehicle Manufacturer ID = '" + source.getID()
			    + "' from ESBD. Vehicle Manufacturer ID = '" + source.getVOITUREMARKID()
			    + "' not found",
		    e);
	}
    }

}
