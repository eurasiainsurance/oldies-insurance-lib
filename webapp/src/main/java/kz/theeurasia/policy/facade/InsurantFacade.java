package kz.theeurasia.policy.facade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import kz.theeurasia.esbdproxy.domain.entities.general.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.KZCityServiceDAO;
import kz.theeurasia.esbdproxy.services.general.SubjectPersonServiceDAO;
import kz.theeurasia.policy.domain.ContactData;
import kz.theeurasia.policy.domain.IdentityCardData;
import kz.theeurasia.policy.domain.InsurantData;
import kz.theeurasia.policy.domain.InsuredDriverData;
import kz.theeurasia.policy.domain.OriginData;
import kz.theeurasia.policy.domain.PersonalData;
import kz.theeurasia.policy.domain.PolicyRequestData;
import kz.theeurasia.policy.domain.ResidenceData;

@ManagedBean
@ViewScoped
public class InsurantFacade {

    @EJB
    private SubjectPersonServiceDAO subjectPersonService;
    @EJB
    KZCityServiceDAO kzCityServiceDAO;

    public void copyDriverDataIntoInsurant(PolicyRequestData policy, InsurantData insurant) {
	InsuredDriverData drv = insurant.getDriverAsInsurant();
	// insurant.setContact(contact);
	insurant.setIdentityCardData(drv.getIdentityCardData());
	insurant.setIdNumber(drv.getIdNumber());
	insurant.setOriginData(drv.getOriginData());
	insurant.setPersonalData(drv.getPersonalData());
	insurant.setTaxPayerNumber(drv.getTaxPayerNumber());
	insurant.setResidenceData(drv.getResidenceData());
	// insurant.setEconomicsSector();
	insurant.setReadyToFill(true);
    }

    public void checkAndClearDriverData(PolicyRequestData policy, InsurantData insurant) {
	if (insurant.isInsurantADriver()) {
	    insurant.setReadyToFill(false);
	    return;
	}
	clearInsurantFromDriverData(insurant);
	insurant.setReadyToFill(true);
    }

    public void clearInsurantFromDriverData(InsurantData insurant) {
	insurant.setIdentityCardData(new IdentityCardData());
	insurant.setIdNumber(null);
	insurant.setOriginData(new OriginData());
	insurant.setPersonalData(new PersonalData());
	insurant.setTaxPayerNumber(null);
	insurant.setResidenceData(new ResidenceData());
    }

    public void fetchInfo(InsurantData insurant) {
	try {
	    SubjectPersonEntity fetched = subjectPersonService.getByIIN(insurant.getIdNumber());
	    insurant.setFetchedEntity(fetched);

	    insurant.getPersonalData().setName(fetched.getPersonal().getName());
	    insurant.getPersonalData().setSurename(fetched.getPersonal().getSurename());
	    insurant.getPersonalData().setPatronymic(fetched.getPersonal().getPatronymic());
	    insurant.getPersonalData().setSex(fetched.getPersonal().getSex());
	    insurant.getPersonalData().setDayOfBirth(fetched.getPersonal().getDayOfBirth().getTime());

	    insurant.getResidenceData().setResident(fetched.getOrigin().isResident());
	    insurant.getResidenceData().setAddress(fetched.getContact().getHomeAdress());

	    // TODO Здесь потенциальная проблема связанная с тем несоответстием
	    // мапирования
	    if (fetched.getOrigin().getCity() != null)
		insurant.getResidenceData().setCity(kzCityServiceDAO.getById(fetched.getOrigin().getCity().getId()));
	    insurant.getOriginData().setCountry(fetched.getOrigin().getCountry());

	    insurant.getIdentityCardData().setDateOfIssue(fetched.getIdentityCard().getDateOfIssue().getTime());
	    insurant.getIdentityCardData().setType(fetched.getIdentityCard().getIdentityCardType());
	    insurant.getIdentityCardData().setIssuingAuthority(fetched.getIdentityCard().getIssuingAuthority());
	    insurant.getIdentityCardData().setNumber(fetched.getIdentityCard().getNumber());

	    insurant.setTaxPayerNumber(fetched.getTaxPayerNumber());

	    insurant.getContact().setEmail(fetched.getContact().getEmail());
	    insurant.getContact().setPhone(fetched.getContact().getPhone());
	    insurant.getContact().setSiteUrl(fetched.getContact().getSiteUrl());

	} catch (NotFound | InvalidInputParameter e) {
	    _resetFetchedInfo(insurant);
	}
    }

    private void _resetFetchedInfo(InsurantData insurant) {
	insurant.setFetchedEntity(null);
	insurant.setPersonalData(new PersonalData());
	insurant.setResidenceData(new ResidenceData());
	insurant.setOriginData(new OriginData());
	insurant.setIdentityCardData(new IdentityCardData());
	insurant.setTaxPayerNumber(null);
	insurant.setContact(new ContactData());
    }
}
