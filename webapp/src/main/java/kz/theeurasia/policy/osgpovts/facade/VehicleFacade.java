package kz.theeurasia.policy.osgpovts.facade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryRegionDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleAgeClassDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleEntity;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.CountryRegionServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleServiceDAO;
import kz.theeurasia.policy.osgpovts.MessageBundleCode;
import kz.theeurasia.policy.osgpovts.ValidationException;
import kz.theeurasia.policy.osgpovts.domain.InsuredVehicle;
import kz.theeurasia.policy.osgpovts.domain.PolicyRequest;

@ManagedBean
@ViewScoped
public class VehicleFacade {

    @EJB
    private CountryRegionServiceDAO countryRegionService;

    @EJB
    private VehicleServiceDAO vehicleService;

    public InsuredVehicle add(PolicyRequest policy) throws ValidationException {
	if (policy.getInsuredVehicles().size() > 0 && policy.getInsuredDrivers().size() > 1)
	    throw new ValidationException(MessageBundleCode.ONLY_ONE_VEHICLE_ALLOWED);
	InsuredVehicle e = new InsuredVehicle();
	policy.getInsuredVehicles().add(e);
	_reset(policy, e);
	return e;
    }

    public void remove(PolicyRequest policy, InsuredVehicle vehicle) throws ValidationException {
	if (policy.getInsuredVehicles().size() <= 1)
	    throw new ValidationException(MessageBundleCode.VEHICLES_LIST_CANT_BE_EMPTY);
	policy.getInsuredVehicles().remove(vehicle);
    }

    public void fetchInfo(PolicyRequest policy, InsuredVehicle vehicle) throws ValidationException {
	try {
	    VehicleEntity fetched = vehicleService.getByVINCode(vehicle.getVinCode());
	    vehicle.setFetchedEntity(fetched);
	    vehicle.setVehicleClass(fetched.getVehicleClass());
	    if (fetched.getRealeaseDate() != null) {
		int age = CalculatorUtil.calculateAgeByDOB(fetched.getRealeaseDate());
		vehicle.setVehicleAgeClass(age > 7 ? VehicleAgeClassDict.OVER7 : VehicleAgeClassDict.UNDER7);
	    }
	    vehicle.setVehicleModel(fetched.getVehicleModel().getName());
	    vehicle.setVehicleManufacturer(fetched.getVehicleModel().getManufacturer().getName());
	} catch (NotFound | InvalidInputParameter e) {
	    _resetFetchedInfo(policy, vehicle);
	}
    }

    public void evaluateMajorCity(InsuredVehicle insuredVehicle) {
	insuredVehicle.setForcedMajorCity(
		insuredVehicle.getRegion().equals(CountryRegionDict.GALM)
			|| insuredVehicle.getRegion().equals(CountryRegionDict.GAST));
	if (insuredVehicle.isForcedMajorCity())
	    insuredVehicle.setMajorCity(true);
    }

    private void _reset(PolicyRequest policy, InsuredVehicle vehicle) {
	_resetFetchedInfo(policy, vehicle);
	vehicle.setVinCode("");
	vehicle.setRegion(countryRegionService.getDefaultRegion());
	evaluateMajorCity(vehicle);
    }

    private void _resetFetchedInfo(PolicyRequest policy, InsuredVehicle vehicle) {
	vehicle.setFetchedEntity(null);
	vehicle.setVehicleClass(VehicleClassDict.CAR);
	vehicle.setVehicleAgeClass(VehicleAgeClassDict.UNDER7);
	vehicle.setVehicleModel("");
	vehicle.setVehicleManufacturer("");
    }

}
