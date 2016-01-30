package kz.theeurasia.esbdproxy.services.ejbimpl;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.Client;
import kz.theeurasia.esbdproxy.domain.dict.CompanyActivityKindDict;
import kz.theeurasia.esbdproxy.domain.dict.EconomicSectorDict;
import kz.theeurasia.esbdproxy.domain.entities.SubjectCompanyEntity;
import kz.theeurasia.esbdproxy.domain.entities.SubjectEntity;
import kz.theeurasia.esbdproxy.services.IdentityCardTypeServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.SexServiceDAO;
import kz.theeurasia.esbdproxy.services.SubjectCompanyServiceDAO;

@Singleton
public class SubjectCompanyServiceWS extends SubjectServiceWS implements SubjectCompanyServiceDAO {

    @EJB
    private IdentityCardTypeServiceDAO identityCardTypeService;

    @EJB
    private SexServiceDAO sexService;

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
	target.setCompanyActivityKind(companyActivityKind);

	// ECONOMICS_SECTOR_ID s:int Сектор экономики (справочник
	// ECONOMICS_SECTORS)
	target.setEconomicsSector(economicsSector);
    }
}
