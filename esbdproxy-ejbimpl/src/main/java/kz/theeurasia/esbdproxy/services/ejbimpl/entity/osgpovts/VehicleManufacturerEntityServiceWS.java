package kz.theeurasia.esbdproxy.services.ejbimpl.entity.osgpovts;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.ArrayOfVOITUREMARK;
import kz.theeurasia.asb.esbd.jaxws.VOITUREMARK;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleManufacturerEntity;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.ejbimpl.DataCoruptionException;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.general.AbstractESBDEntityServiceWS;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleManufacturerServiceDAO;

@Singleton
public class VehicleManufacturerEntityServiceWS extends AbstractESBDEntityServiceWS
	implements VehicleManufacturerServiceDAO {

    @EJB
    private VehicleManufacturerServiceDAO vehicleManufacturerService;

    @Override
    public VehicleManufacturerEntity getById(Long id) throws NotFound {
	if (id == null)
	    throw new InvalidParameterException("ID must be not null");
	checkSession();
	VOITUREMARK m = new VOITUREMARK();
	m.setID(new Long(id).intValue());
	ArrayOfVOITUREMARK manufacturers = getSoapService().getVoitureMarks(getSessionId(), m);
	if (manufacturers == null || manufacturers.getVOITUREMARK() == null || manufacturers.getVOITUREMARK().isEmpty())
	    throw new NotFound(VehicleManufacturerEntity.class.getSimpleName() + " not found with ID = '" + id + "'");
	if (manufacturers.getVOITUREMARK().size() > 1)
	    throw new DataCoruptionException(
		    "Too many " + VehicleManufacturerEntity.class.getSimpleName() + " ("
			    + manufacturers.getVOITUREMARK().size() + ") with ID = '" + id + "'");

	VehicleManufacturerEntity manufacturer = new VehicleManufacturerEntity();
	fillValues(manufacturers.getVOITUREMARK().iterator().next(), manufacturer);
	return manufacturer;
    }

    @Override
    public List<VehicleManufacturerEntity> getByName(String name) {
	if (name == null || name.trim().isEmpty())
	    throw new InvalidParameterException("'name' must be not an empty string");
	List<VehicleManufacturerEntity> res = new ArrayList<>();
	VOITUREMARK m = new VOITUREMARK();
	m.setNAME(name);
	ArrayOfVOITUREMARK manufacturers = getSoapService().getVoitureMarks(getSessionId(), m);
	if (manufacturers == null || manufacturers.getVOITUREMARK() == null || manufacturers.getVOITUREMARK().isEmpty())
	    return res;
	for (VOITUREMARK source : manufacturers.getVOITUREMARK()) {
	    VehicleManufacturerEntity e = new VehicleManufacturerEntity();
	    fillValues(source, e);
	    res.add(e);
	}
	return res;
    }

    private void fillValues(VOITUREMARK source, VehicleManufacturerEntity target) {
	target.setId(source.getID());
	target.setName(source.getNAME());
	target.setForeign(source.getISFOREIGNBOOL() != 0);
    }
}
