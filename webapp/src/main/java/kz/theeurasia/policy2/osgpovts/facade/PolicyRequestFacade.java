package kz.theeurasia.policy2.osgpovts.facade;

import java.util.Calendar;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryRegionDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleAgeClassDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleEntity;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredAgeClassEnum;
import kz.theeurasia.esbdproxy.domain.infos.general.IdentityCardInfo;
import kz.theeurasia.esbdproxy.domain.infos.general.OriginInfo;
import kz.theeurasia.esbdproxy.domain.infos.general.PersonalInfo;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.CountryRegionServiceDAO;
import kz.theeurasia.esbdproxy.services.general.SubjectPersonServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.InsuranceClassTypeServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleServiceDAO;
import kz.theeurasia.policy2.osgpovts.MessageBundleCode;
import kz.theeurasia.policy2.osgpovts.ValidationException;
import kz.theeurasia.policy2.osgpovts.domain.InsuredDriver;
import kz.theeurasia.policy2.osgpovts.domain.InsuredVehicle;
import kz.theeurasia.policy2.osgpovts.domain.PolicyRequest;

@ManagedBean
@ViewScoped
public class PolicyRequestFacade {

    @EJB
    private SubjectPersonServiceDAO subjectPersonService;

    @EJB
    private InsuranceClassTypeServiceDAO insuranceClassTypeService;

    @EJB
    private CountryRegionServiceDAO countryRegionService;

    @EJB
    private VehicleServiceDAO vehicleService;

    public PolicyRequest initNew() throws ValidationException {
	PolicyRequest policy = new PolicyRequest();
	addInsuredDriver(policy);
	addInsuredVehicle(policy);
	return policy;
    }

    public InsuredDriver addInsuredDriver(PolicyRequest policy) throws ValidationException {
	if (policy.getInsuredVehicles().size() > 1)
	    throw new ValidationException(MessageBundleCode.ONLY_ONE_DRIVER_ALLOWED);
	InsuredDriver e = new InsuredDriver();
	policy.getInsuredDrivers().add(e);
	return e;
    }

    public void removeInsuredDriver(PolicyRequest policy, InsuredDriver driver) throws ValidationException {
	if (policy.getInsuredDrivers().size() <= 1)
	    throw new ValidationException(MessageBundleCode.DRIVER_LIST_CANT_BE_EMPTY);
	policy.getInsuredDrivers().remove(driver);
    }

    public InsuredVehicle addInsuredVehicle(PolicyRequest policy) throws ValidationException {
	if (policy.getInsuredDrivers().size() > 1)
	    throw new ValidationException(MessageBundleCode.ONLY_ONE_VEHICLE_ALLOWED);
	InsuredVehicle e = new InsuredVehicle();
	policy.getInsuredVehicles().add(e);
	e.setRegion(countryRegionService.getDefaultRegion());
	evaluateMajorCity(e);
	return e;
    }

    public void removeInsuredVehicle(PolicyRequest policy, InsuredVehicle vehicle) throws ValidationException {
	if (policy.getInsuredVehicles().size() <= 1)
	    throw new ValidationException(MessageBundleCode.VEHICLES_LIST_CANT_BE_EMPTY);
	policy.getInsuredVehicles().remove(vehicle);
    }

    public void clearInsuredDriverFetchedInfo(PolicyRequest policy, InsuredDriver driver) {
	driver.setFetchedEntity(null);
	driver.setPersonal(new PersonalInfo());
	driver.setOrigin(new OriginInfo());
	driver.setIdentityCard(new IdentityCardInfo());
	driver.setTaxPayerNumber("");
	driver.setInsuranceClassType(insuranceClassTypeService.getDefault());
    }

    public void fetchInsuredDriver(PolicyRequest policy, InsuredDriver driver) throws ValidationException {
	if (driver.getIdNumber() == null || driver.getIdNumber().isEmpty())
	    throw new ValidationException(MessageBundleCode.ID_NUMBER_CANT_BE_EMPTY);
	try {
	    SubjectPersonEntity fetched = subjectPersonService.getByIIN(driver.getIdNumber());
	    driver.setFetchedEntity(fetched);
	    driver.setPersonal(fetched.getPersonal());
	    driver.setOrigin(fetched.getOrigin());
	    driver.setIdentityCard(fetched.getIdentityCard());
	    driver.setTaxPayerNumber(fetched.getTaxPayerNumber());
	    try {
		InsuranceClassTypeDict insuranceClassType = insuranceClassTypeService.getForSubject(fetched);
		driver.setInsuranceClassType(insuranceClassType);
	    } catch (NotFound e) {
		driver.setInsuranceClassType(insuranceClassTypeService.getDefault());
	    }
	    if (fetched.getPersonal().getDayOfBirth() != null) {
		int years = calculateAgeByDOB(driver.getPersonal().getDayOfBirth());
		driver.setAgeClass(years > 25 ? InsuredAgeClassEnum.OVER25 : InsuredAgeClassEnum.UNDER25);
	    }
	} catch (NotFound e) {
	    clearInsuredDriverFetchedInfo(policy, driver);
	}
    }

    public void clearInsuredVehicleFetchedInfo(PolicyRequest policy, InsuredVehicle vehicle) {
	vehicle.setFetchedEntity(null);
	vehicle.setVehicleClass(VehicleClassDict.UNSPECIFIED);
	vehicle.setVehicleAgeClass(VehicleAgeClassDict.UNSPECIFIED);
	vehicle.setVehicleModel("");
	vehicle.setVehicleManufacturer("");
    }

    public void fetchInsuredVehicle(PolicyRequest policy, InsuredVehicle vehicle) throws ValidationException {
	if (vehicle.getVinCode() == null || vehicle.getVinCode().isEmpty())
	    throw new ValidationException(MessageBundleCode.VIN_CODE_CANT_BE_EMPTY);
	try {
	    VehicleEntity fetched = vehicleService.getByVINCode(vehicle.getVinCode());
	    vehicle.setFetchedEntity(fetched);
	    vehicle.setVehicleClass(fetched.getVehicleClass());
	    if (fetched.getRealeaseDate() != null) {
		int age = calculateAgeByDOB(fetched.getRealeaseDate());
		vehicle.setVehicleAgeClass(age > 7 ? VehicleAgeClassDict.OVER7 : VehicleAgeClassDict.UNDER7);
	    }
	    vehicle.setVehicleModel(fetched.getVehicleModel().getName());
	    vehicle.setVehicleManufacturer(fetched.getVehicleModel().getManufacturer().getName());
	} catch (NotFound e) {
	    clearInsuredVehicleFetchedInfo(policy, vehicle);
	}
    }

    public void evaluateMajorCity(InsuredVehicle insuredVehicle) {
	insuredVehicle.setForcedMajorCity(
		insuredVehicle.getRegion().equals(CountryRegionDict.GALM)
			|| insuredVehicle.getRegion().equals(CountryRegionDict.GAST));
	if (insuredVehicle.isForcedMajorCity())
	    insuredVehicle.setMajorCity(true);
    }

    private int calculateAgeByDOB(Calendar dob) {
	Calendar now = Calendar.getInstance();
	int age = now.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
	if (now.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
	    age--;
	} else if (now.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
		&& now.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
	    age--;
	}
	return age;
    }

}
