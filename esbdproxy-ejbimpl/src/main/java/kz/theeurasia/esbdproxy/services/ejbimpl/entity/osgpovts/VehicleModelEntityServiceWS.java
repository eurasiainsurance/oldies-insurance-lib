package kz.theeurasia.esbdproxy.services.ejbimpl.entity.osgpovts;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.ArrayOfVOITUREMODEL;
import kz.theeurasia.asb.esbd.jaxws.VOITUREMODEL;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleManufacturerEntity;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleModelEntity;
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
    public VehicleModelEntity getById(Long id) throws NotFound {
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
    public List<VehicleModelEntity> getByName(String name) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<VehicleModelEntity> getByManufacturer(VehicleManufacturerEntity manufacturer) {
	// TODO Auto-generated method stub
	return null;
    }

    private void fillValues(VOITUREMODEL source, VehicleModelEntity target) {
	target.setId(source.getID());
	target.setName(source.getNAME());
	try {
	    target.setManufacturer(vehicleManufacturerService.getById(new Long(source.getVOITUREMARKID())));
	} catch (NotFound e) {
	    // mandatory field
	    throw new DataCoruptionException(
		    "Error while fetching Vehicle Manufacturer ID = '" + source.getID()
			    + "' from ESBD. Vehicle Manufacturer ID = '" + source.getVOITUREMARKID()
			    + "' not found",
		    e);
	}
    }

}
