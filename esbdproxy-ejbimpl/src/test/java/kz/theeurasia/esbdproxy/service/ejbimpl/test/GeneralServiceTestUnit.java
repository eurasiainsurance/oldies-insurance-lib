package kz.theeurasia.esbdproxy.service.ejbimpl.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;

import kz.theeurasia.esbdproxy.services.BranchServiceDAO;
import kz.theeurasia.esbdproxy.services.CancelationReasonServiceDAO;
import kz.theeurasia.esbdproxy.services.CompanyActivityKindServiceDAO;
import kz.theeurasia.esbdproxy.services.CountryRegionServiceDAO;
import kz.theeurasia.esbdproxy.services.CountryServiceDAO;
import kz.theeurasia.esbdproxy.services.EconomicSectorServiceDAO;
import kz.theeurasia.esbdproxy.services.IdentityCardTypeServiceDAO;
import kz.theeurasia.esbdproxy.services.InsuranceCompanyServiceDAO;
import kz.theeurasia.esbdproxy.services.MaritalStatusServiceDAO;
import kz.theeurasia.esbdproxy.services.PolicyServiceDAO;
import kz.theeurasia.esbdproxy.services.SexServiceDAO;
import kz.theeurasia.esbdproxy.services.SubjectCompanyServiceDAO;
import kz.theeurasia.esbdproxy.services.SubjectPersonServiceDAO;
import kz.theeurasia.esbdproxy.services.SubjectServiceDAO;
import kz.theeurasia.esbdproxy.services.UserServiceDAO;
import kz.theeurasia.esbdproxy.services.VehicleModelServiceDAO;
import kz.theeurasia.esbdproxy.services.VehicleServiceDAO;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.CancelationReasonDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.CountryDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.CountryRegionDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.EconomicSectorDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.IdentityCardTypeDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.MaritalStatusDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.SexDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.osgpovts.InsuranceClassTypeDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.osgpovts.InsuredAgeExpirienceClassDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.osgpovts.VehicleAgeClassDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.osgpovts.VehicleClassDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.BranchEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.CompanyActivityKindEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.InsuranceCompanyEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.SubjectCompanyEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.SubjectEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.SubjectPersonEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.UserEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.osgpovts.PolicyEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.osgpovts.VehicleEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.osgpovts.VehicleModelEntityServiceWS;
import kz.theeurasia.esbdproxy.services.osgpovts.InsuranceClassTypeServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.InsuredAgeExpirienceClassServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleAgeClassServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleClassServiceDAO;

public abstract class GeneralServiceTestUnit {
    private static final String OPEN_EJB_CONTEXT_FACTORY = "org.apache.openejb.client.LocalInitialContextFactory";

    private static Context context;

    @BeforeClass
    public static void initContext() throws NamingException {
	Properties props = new Properties();
	props.put(Context.INITIAL_CONTEXT_FACTORY, OPEN_EJB_CONTEXT_FACTORY);
	context = new InitialContext(props);
    }

    private static String nameFor(Class<?> cls) {
	return cls.getSimpleName() + "Local";
    }

    protected CancelationReasonServiceDAO getCancelationReasonService() throws NamingException {
	return (CancelationReasonServiceDAO) context
		.lookup(nameFor(CancelationReasonDictServiceWS.class));
    }

    protected BranchServiceDAO getBranchServiceEntityWS() throws NamingException {
	return (BranchServiceDAO) context.lookup(nameFor(BranchEntityServiceWS.class));
    }

    protected CancelationReasonServiceDAO getCancelationReasonServiceEntityWS() throws NamingException {
	return (CancelationReasonServiceDAO) context.lookup(nameFor(CancelationReasonDictServiceWS.class));
    }

    protected CompanyActivityKindServiceDAO getCompanyActivityKindServiceEntityWS() throws NamingException {
	return (CompanyActivityKindServiceDAO) context.lookup(nameFor(CompanyActivityKindEntityServiceWS.class));
    }

    protected CountryRegionServiceDAO getCountryRegionServiceEntityWS() throws NamingException {
	return (CountryRegionServiceDAO) context.lookup(nameFor(CountryRegionDictServiceWS.class));
    }

    protected CountryServiceDAO getCountryServiceEntityWS() throws NamingException {
	return (CountryServiceDAO) context.lookup(nameFor(CountryDictServiceWS.class));
    }

    protected EconomicSectorServiceDAO getEconomicSectorServiceEntityWS() throws NamingException {
	return (EconomicSectorServiceDAO) context.lookup(nameFor(EconomicSectorDictServiceWS.class));
    }

    protected IdentityCardTypeServiceDAO getIdentityCardTypeServiceEntityWS() throws NamingException {
	return (IdentityCardTypeServiceDAO) context.lookup(nameFor(IdentityCardTypeDictServiceWS.class));
    }

    protected InsuranceCompanyServiceDAO getInsuranceCompanyServiceEntityWS() throws NamingException {
	return (InsuranceCompanyServiceDAO) context.lookup(nameFor(InsuranceCompanyEntityServiceWS.class));
    }

    protected MaritalStatusServiceDAO getMaritalStatusServiceEntityWS() throws NamingException {
	return (MaritalStatusServiceDAO) context.lookup(nameFor(MaritalStatusDictServiceWS.class));
    }

    protected PolicyServiceDAO getPolicyServiceEntityWS() throws NamingException {
	return (PolicyServiceDAO) context.lookup(nameFor(PolicyEntityServiceWS.class));
    }

    protected SexServiceDAO getSexServiceEntityWS() throws NamingException {
	return (SexServiceDAO) context.lookup(nameFor(SexDictServiceWS.class));
    }

    protected SubjectCompanyServiceDAO getSubjectCompanyServiceEntityWS() throws NamingException {
	return (SubjectCompanyServiceDAO) context.lookup(nameFor(SubjectCompanyEntityServiceWS.class));
    }

    protected SubjectPersonServiceDAO getSubjectPersonServiceEntityWS() throws NamingException {
	return (SubjectPersonServiceDAO) context.lookup(nameFor(SubjectPersonEntityServiceWS.class));
    }

    protected SubjectServiceDAO getSubjectServiceEntityWS() throws NamingException {
	return (SubjectServiceDAO) context.lookup(nameFor(SubjectEntityServiceWS.class));
    }

    protected UserServiceDAO getUserServiceEntityWS() throws NamingException {
	return (UserServiceDAO) context.lookup(nameFor(UserEntityServiceWS.class));
    }

    protected VehicleModelServiceDAO getVehicleModelServiceEntityWS() throws NamingException {
	return (VehicleModelServiceDAO) context.lookup(nameFor(VehicleModelEntityServiceWS.class));
    }

    protected VehicleServiceDAO getVehicleServiceEntityWS() throws NamingException {
	return (VehicleServiceDAO) context.lookup(nameFor(VehicleEntityServiceWS.class));
    }

    protected InsuranceClassTypeServiceDAO getInsuranceClassTypeServiceEntityWS() throws NamingException {
	return (InsuranceClassTypeServiceDAO) context.lookup(nameFor(InsuranceClassTypeDictServiceWS.class));
    }

    protected InsuredAgeExpirienceClassServiceDAO getInsuredAgeExpirienceClassServiceEntityWS() throws NamingException {
	return (InsuredAgeExpirienceClassServiceDAO) context
		.lookup(nameFor(InsuredAgeExpirienceClassDictServiceWS.class));
    }

    protected VehicleAgeClassServiceDAO getVehicleAgeClassServiceEntityWS() throws NamingException {
	return (VehicleAgeClassServiceDAO) context.lookup(nameFor(VehicleAgeClassDictServiceWS.class));
    }

    protected VehicleClassServiceDAO getVehicleClassServiceEntityWS() throws NamingException {
	return (VehicleClassServiceDAO) context.lookup(nameFor(VehicleClassDictServiceWS.class));
    }
}
