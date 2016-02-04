package kz.theeurasia.policy.osgpovts.facade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredAgeClassEnum;
import kz.theeurasia.esbdproxy.domain.infos.general.IdentityCardInfo;
import kz.theeurasia.esbdproxy.domain.infos.general.OriginInfo;
import kz.theeurasia.esbdproxy.domain.infos.general.PersonalInfo;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.SubjectPersonServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.InsuranceClassTypeServiceDAO;
import kz.theeurasia.policy.osgpovts.MessageBundleCode;
import kz.theeurasia.policy.osgpovts.ValidationException;
import kz.theeurasia.policy.osgpovts.domain.InsuredDriver;
import kz.theeurasia.policy.osgpovts.domain.PolicyRequest;

@ManagedBean
@ViewScoped
public class DriverFacade {

    @EJB
    private SubjectPersonServiceDAO subjectPersonService;

    @EJB
    private InsuranceClassTypeServiceDAO insuranceClassTypeService;

    public InsuredDriver add(PolicyRequest policy) throws ValidationException {
	if (policy.getInsuredVehicles().size() > 1)
	    throw new ValidationException(MessageBundleCode.ONLY_ONE_DRIVER_ALLOWED);
	InsuredDriver e = new InsuredDriver();
	policy.getInsuredDrivers().add(e);
	_reset(policy, e);
	return e;
    }

    public void remove(PolicyRequest policy, InsuredDriver driver) throws ValidationException {
	if (policy.getInsuredDrivers().size() <= 1)
	    throw new ValidationException(MessageBundleCode.DRIVER_LIST_CANT_BE_EMPTY);
	policy.getInsuredDrivers().remove(driver);
    }

    public void fetchInfo(PolicyRequest policy, InsuredDriver driver) throws ValidationException {
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
		int years = CalculatorUtil.calculateAgeByDOB(driver.getPersonal().getDayOfBirth());
		driver.setAgeClass(years > 25 ? InsuredAgeClassEnum.OVER25 : InsuredAgeClassEnum.UNDER25);
	    }
	} catch (NotFound | InvalidInputParameter e) {
	    _resetFetchedInfo(policy, driver);
	}
    }

    private void _reset(PolicyRequest policy, InsuredDriver driver) {
	_resetFetchedInfo(policy, driver);
    }

    private void _resetFetchedInfo(PolicyRequest policy, InsuredDriver driver) {
	driver.setFetchedEntity(null);
	driver.setPersonal(new PersonalInfo());
	driver.setOrigin(new OriginInfo());
	driver.setIdentityCard(new IdentityCardInfo());
	driver.setTaxPayerNumber("");
	driver.setInsuranceClassType(insuranceClassTypeService.getDefault());
	driver.setAgeClass(InsuredAgeClassEnum.OVER25);
    }
}
