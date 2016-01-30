package kz.theeurasia.esbdproxy.services.ejbimpl.entity.osgpovts;

import java.util.Calendar;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.ArrayOfTF;
import kz.theeurasia.asb.esbd.jaxws.TF;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleEntity;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.SteeringWheelLocationEnum;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.VehicleModelServiceDAO;
import kz.theeurasia.esbdproxy.services.VehicleServiceDAO;
import kz.theeurasia.esbdproxy.services.ejbimpl.DataCoruptionException;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.AbstractESBDEntityServiceWS;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleClassServiceDAO;

@Singleton
public class VehicleEntityServiceWS extends AbstractESBDEntityServiceWS implements VehicleServiceDAO {

    @EJB
    private VehicleClassServiceDAO vehicleClassService;

    @EJB
    private VehicleModelServiceDAO vehicleModelService;

    @Override
    public VehicleEntity getById(Long id) throws NotFound {
	checkSession();
	TF tf = new TF();
	tf.setTFID(new Long(id).intValue());
	ArrayOfTF vehicles = getSoapService().getTFByKeyFields(getSessionId(), tf);
	if (vehicles == null || vehicles.getTF() == null || vehicles.getTF().size() == 0)
	    throw new NotFound(VehicleEntity.class.getSimpleName() + " not found with ID = '" + id + "'");
	if (vehicles.getTF().size() > 1)
	    throw new DataCoruptionException("Too many (" + vehicles.getTF().size() + ") with ID = '" + id + "'");

	VehicleEntity vehicle = new VehicleEntity();
	fillValues(vehicles.getTF().iterator().next(), vehicle);
	return vehicle;
    }

    @Override
    public VehicleEntity getByVINCode(String vinCode) throws NotFound {
	checkSession();
	ArrayOfTF vehicles = getSoapService().getTFByVIN(getSessionId(), vinCode);
	if (vehicles == null || vehicles.getTF() == null || vehicles.getTF().size() == 0)
	    throw new NotFound("Not found with VIN = '" + vinCode + "'");
	if (vehicles.getTF().size() > 1)
	    throw new DataCoruptionException("Too many (" + vehicles.getTF().size() + ") with VIN = '" + vinCode + "'");

	VehicleEntity vehicle = new VehicleEntity();
	fillValues(vehicles.getTF().iterator().next(), vehicle);
	return vehicle;
    }

    void fillValues(TF source, VehicleEntity target) {
	// TF_ID s:int Идентификатор ТС
	target.setId(source.getTFID());

	// TF_TYPE_ID s:int Тип ТС (справочник TF_TYPES)
	try {
	    target.setVehicleClass(vehicleClassService.getById(new Long(source.getTFTYPEID())));
	} catch (NotFound e) {
	    // non mandatory field
	    target.setVehicleClass(VehicleClassDict.UNSPECIFIED);
	}

	// VIN s:string VIN код (номер кузова) (обязательно)
	target.setVinCode(source.getVIN());

	// MODEL_ID s:int Марка\Модель (справочник VOITURE_MODELS) (обязательно)
	try {
	    target.setVehicleModel(vehicleModelService.getById(new Long(source.getMODELID())));
	} catch (NotFound e) {
	    // mandatory field
	    throw new DataCoruptionException(
		    "Error while fetching Vehicle ID = '" + source.getTFID()
			    + "' from ESBD. VehicleModel ID = '" + source.getMODELID()
			    + "' not found",
		    e);
	}

	// RIGHT_HAND_DRIVE_BOOL s:int Признак расположения руля (0 - слева; 1 -
	// справа)
	target.setSteeringWheelLocation(source.getRIGHTHANDDRIVEBOOL() == 0 ? SteeringWheelLocationEnum.LEFT_SIDE
		: SteeringWheelLocationEnum.RIGHT_SIDE);

	// ENGINE_VOLUME s:int Объем двигателя (куб.см.)
	target.setEngineVolume(source.getENGINEVOLUME());

	// ENGINE_NUMBER s:string Номер двигателя
	target.setEnineNumber(source.getENGINENUMBER());

	// ENGINE_POWER s:int Мощность двигателя (квт.)
	target.setEnginePower(source.getENGINEPOWER());

	// COLOR s:string Цвет ТС
	target.setColor(source.getCOLOR());

	// BORN s:string Год выпуска (обязательно)
	// BORN_MONTH s:int Месяц выпуска ТС
	Calendar releaseDate = Calendar.getInstance();
	int year;
	try {
	    year = Integer.parseInt(source.getBORN());
	    if (year < 1000 || year > 9999)
		year = 0;
	} catch (NumberFormatException e) {
	    year = 0;
	}
	releaseDate.set(year, source.getBORNMONTH(), 1, 0, 0, 0);
	target.setRealeaseDate(releaseDate);
    }

}
