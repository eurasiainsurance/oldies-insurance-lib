package kz.theeurasia.esbdproxy.services.ejbimpl.entity;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.Client;
import kz.theeurasia.esbdproxy.domain.entities.SubjectCompanyEntity;
import kz.theeurasia.esbdproxy.domain.entities.SubjectEntity;
import kz.theeurasia.esbdproxy.services.CompanyActivityKindServiceDAO;
import kz.theeurasia.esbdproxy.services.EconomicSectorServiceDAO;
import kz.theeurasia.esbdproxy.services.IdentityCardTypeServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.SexServiceDAO;
import kz.theeurasia.esbdproxy.services.SubjectCompanyServiceDAO;
import kz.theeurasia.esbdproxy.services.ejbimpl.DataCoruptionException;

@Singleton
public class SubjectCompanyEntityServiceWS extends SubjectEntityServiceWS implements SubjectCompanyServiceDAO {

    @EJB
    private IdentityCardTypeServiceDAO identityCardTypeService;

    @EJB
    private SexServiceDAO sexService;

    @EJB
    private CompanyActivityKindServiceDAO companyActivityKindService;

    @EJB
    private EconomicSectorServiceDAO econimicsSectorService;

    @Override
    public SubjectCompanyEntity getById(Long id) throws NotFound {
	checkSession();

	Client source = getSoapService().getClientByID(getSessionId(), id.intValue());
	if (source == null)
	    throw new NotFound("Not found with ID = '" + id + "'");
	SubjectCompanyEntity target = new SubjectCompanyEntity();
	fillValues(source, (SubjectEntity) target);
	fillValues(source, target);
	return target;
    }

    void fillValues(Client source, SubjectCompanyEntity target) {
	// Juridical_Person_Name s:string Наименование (для юр. лица)
	target.setCompanyName(source.getJuridicalPersonName());

	// MAIN_CHIEF s:string Первый руководитель
	target.setHeadName(source.getMAINCHIEF());

	// MAIN_ACCOUNTANT s:string Главный бухгалтер
	target.setAccountantName(source.getMAINACCOUNTANT());

	// ACTIVITY_KIND_ID s:int Вид деятельности (справочник ACTIVITY_KINDS)
	try {
	    target.setCompanyActivityKind(companyActivityKindService.getById(new Long(source.getACTIVITYKINDID())));
	} catch (NotFound e) {
	    // mandatory field
	    throw new DataCoruptionException(
		    "Error while fetching Company Client ID = '" + source.getID()
			    + "' from ESBD. CompanyActivityKind ID = '"
			    + source.getACTIVITYKINDID() + "' not found",
		    e);
	}

	// ECONOMICS_SECTOR_ID s:int Сектор экономики (справочник
	// ECONOMICS_SECTORS)
	try {
	    target.setEconomicsSector(econimicsSectorService.getById(new Long(source.getECONOMICSSECTORID())));
	} catch (NotFound e) {
	    // mandatory field
	    throw new DataCoruptionException(
		    "Error while fetching Company Client ID = '" + source.getID()
			    + "' from ESBD. Economics Sector ID = '"
			    + source.getECONOMICSSECTORID() + "' not found",
		    e);
	}
    }
}
