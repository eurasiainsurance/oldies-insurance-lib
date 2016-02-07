package kz.theeurasia.policy.osgpovts.facade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuranceClassTypeDict;
import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredAgeClassEnum;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredExpirienceClassEnum;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.SubjectPersonServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.InsuranceClassTypeServiceDAO;
import kz.theeurasia.policy.general.domain.IdentityCardData;
import kz.theeurasia.policy.general.domain.OriginData;
import kz.theeurasia.policy.general.domain.PersonalData;
import kz.theeurasia.policy.osgpovts.MessageBundleCode;
import kz.theeurasia.policy.osgpovts.ValidationException;
import kz.theeurasia.policy.osgpovts.domain.InsuredDriverData;
import kz.theeurasia.policy.osgpovts.domain.PolicyRequestData;

@ManagedBean
@ViewScoped
public class DriverFacade {

    @EJB
    private SubjectPersonServiceDAO subjectPersonService;

    @EJB
    private InsuranceClassTypeServiceDAO insuranceClassTypeService;

    public InsuredDriverData add(PolicyRequestData policy) throws ValidationException {
	if (policy.getInsuredDrivers().size() > 0 && policy.getInsuredVehicles().size() > 1)
	    throw new ValidationException(MessageBundleCode.ONLY_ONE_DRIVER_ALLOWED);
	InsuredDriverData e = new InsuredDriverData();
	policy.getInsuredDrivers().add(e);
	_reset(policy, e);
	return e;
    }

    public void remove(PolicyRequestData policy, InsuredDriverData driver) throws ValidationException {
	if (policy.getInsuredDrivers().size() <= 1)
	    throw new ValidationException(MessageBundleCode.DRIVER_LIST_CANT_BE_EMPTY);
	policy.getInsuredDrivers().remove(driver);
    }

    public void fetchInfo(PolicyRequestData policy, InsuredDriverData driver) throws ValidationException {
	try {
	    SubjectPersonEntity fetched = subjectPersonService.getByIIN(driver.getIdNumber());
	    driver.setFetchedEntity(fetched);

	    driver.getPersonalData().setName(fetched.getPersonal().getName());
	    driver.getPersonalData().setSurename(fetched.getPersonal().getSurename());
	    driver.getPersonalData().setPatronymic(fetched.getPersonal().getPatronymic());
	    driver.getPersonalData().setSex(fetched.getPersonal().getSex());
	    driver.getPersonalData().setDayOfBirth(fetched.getPersonal().getDayOfBirth().getTime());

	    driver.getOriginData().setCity(fetched.getOrigin().getCity());
	    driver.getOriginData().setCountry(fetched.getOrigin().getCountry());
	    driver.getOriginData().setResident(fetched.getOrigin().isResident());

	    driver.getIdentityCardData().setDateOfIssue(fetched.getIdentityCard().getDateOfIssue().getTime());
	    driver.getIdentityCardData().setIdentityCardType(fetched.getIdentityCard().getIdentityCardType());
	    driver.getIdentityCardData().setIssuingAuthority(fetched.getIdentityCard().getIssuingAuthority());
	    driver.getIdentityCardData().setNumber(fetched.getIdentityCard().getNumber());

	    driver.setTaxPayerNumber(fetched.getTaxPayerNumber());
	    try {
		InsuranceClassTypeDict insuranceClassType = insuranceClassTypeService.getForSubject(fetched);
		driver.setInsuranceClassType(insuranceClassType);
	    } catch (NotFound e) {
		driver.setInsuranceClassType(insuranceClassTypeService.getDefault());
	    }
	    if (fetched.getPersonal().getDayOfBirth() != null) {
		int years = CalculatorUtil.calculateAgeByDOB(driver.getPersonalData().getDayOfBirth());
		driver.setAgeClass(years > 25 ? InsuredAgeClassEnum.OVER25 : InsuredAgeClassEnum.UNDER25);
	    }
	} catch (NotFound | InvalidInputParameter e) {
	    _resetFetchedInfo(policy, driver);
	}
    }

    private void _reset(PolicyRequestData policy, InsuredDriverData driver) {
	_resetFetchedInfo(policy, driver);
	driver.setExpirienceClass(InsuredExpirienceClassEnum.MORE2);
    }

    private void _resetFetchedInfo(PolicyRequestData policy, InsuredDriverData driver) {
	driver.setFetchedEntity(null);
	driver.setPersonalData(new PersonalData());
	driver.setOriginData(new OriginData());
	driver.setIdentityCardData(new IdentityCardData());
	driver.setTaxPayerNumber("");
	driver.setInsuranceClassType(insuranceClassTypeService.getDefault());
	driver.setAgeClass(InsuredAgeClassEnum.OVER25);
    }
}
