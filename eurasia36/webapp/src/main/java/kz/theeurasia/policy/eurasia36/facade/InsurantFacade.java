package kz.theeurasia.policy.eurasia36.facade;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

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

@Named
@ViewScoped
public class InsurantFacade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private SubjectPersonServiceDAO subjectPersonService;

    @Inject
    private KZCityServiceDAO kzCityServiceDAO;

    public void copyDriverAsInsurantData(PolicyRequestData policy, InsurantData insurant) {
	InsuredDriverData drv = insurant.getDriverAsInsurant();
	insurant.setIdNumber(drv.getIdNumber());

	insurant.getPersonalData().setName(drv.getPersonalData().getName());
	insurant.getPersonalData().setSurename(drv.getPersonalData().getSurename());
	insurant.getPersonalData().setPatronymic(drv.getPersonalData().getPatronymic());
	insurant.getPersonalData().setDayOfBirth(drv.getPersonalData().getDayOfBirth());
	insurant.getPersonalData().setSex(drv.getPersonalData().getSex());

	insurant.getResidenceData().setResident(drv.getResidenceData().isResident());
	insurant.getResidenceData().setAddress(drv.getResidenceData().getAddress());
	insurant.getResidenceData().setCity(drv.getResidenceData().getCity());

	insurant.getOriginData().setCountry(drv.getOriginData().getCountry());

	insurant.setIdentityCardData(drv.getIdentityCardData());
	insurant.getIdentityCardData().setDateOfIssue(drv.getIdentityCardData().getDateOfIssue());
	insurant.getIdentityCardData().setIssuingAuthority(drv.getIdentityCardData().getIssuingAuthority());
	insurant.getIdentityCardData().setNumber(drv.getIdentityCardData().getNumber());
	insurant.getIdentityCardData().setType(drv.getIdentityCardData().getType());

	insurant.setTaxPayerNumber(drv.getTaxPayerNumber());
    }

    public void clearDriverAsInsurantData(InsurantData insurant) {
	insurant.setDriverAsInsurant(null);

	insurant.setIdentityCardData(new IdentityCardData());
	insurant.setIdNumber(null);
	insurant.setOriginData(new OriginData());
	insurant.setPersonalData(new PersonalData());
	insurant.setTaxPayerNumber(null);
	insurant.setResidenceData(new ResidenceData());
    }

    public void fetchInfo(InsurantData insurant, PolicyRequestData policy) {
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
	    if (fetched.getOrigin().getCity() != null)
		insurant.getResidenceData().setCity(kzCityServiceDAO.getById(fetched.getOrigin().getCity().getId()));

	    insurant.getOriginData().setCountry(fetched.getOrigin().getCountry());

	    insurant.getIdentityCardData().setDateOfIssue(fetched.getIdentityCard().getDateOfIssue().getTime());
	    insurant.getIdentityCardData().setType(fetched.getIdentityCard().getIdentityCardType());
	    insurant.getIdentityCardData().setIssuingAuthority(fetched.getIdentityCard().getIssuingAuthority());
	    insurant.getIdentityCardData().setNumber(fetched.getIdentityCard().getNumber());

	    insurant.setTaxPayerNumber(fetched.getTaxPayerNumber());

	    insurant.getContactData().setEmail(fetched.getContact().getEmail());
	    insurant.getContactData().setPhone(fetched.getContact().getPhone());
	    insurant.getContactData().setSiteUrl(fetched.getContact().getSiteUrl());

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
	insurant.setContactData(new ContactData());
    }

    public void handleWhoIsInsurantChange(PolicyRequestData policy, InsurantData insurant) {
	switch (insurant.getWhoIsInsurant()) {
	case DRIVER:
	    clearDriverAsInsurantData(insurant);
	    if (policy.getInsuredDrivers().size() == 1) {
		// если в списке застрахованных водил только один, то он и
		// является страхователем
		insurant.setDriverAsInsurant(policy.getInsuredDrivers().get(0));
		copyDriverAsInsurantData(policy, insurant);
	    }
	    break;
	case OTHER:
	    clearDriverAsInsurantData(insurant);
	    break;
	case UNSPECIFIED:
	default:
	}
    }
}
