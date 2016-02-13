package kz.theeurasia.esbdproxy.service.ejbimpl.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;

import kz.theeurasia.esbdproxy.services.ejbimpl.dict.general.CancelationReasonDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.general.CountryDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.general.CountryRegionDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.general.EconomicSectorDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.general.IdentityCardTypeDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.general.KZCityDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.general.MaritalStatusDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.general.SexDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.osgpovts.InsuranceClassTypeDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.osgpovts.InsuredAgeExpirienceClassDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.osgpovts.VehicleAgeClassDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.dict.osgpovts.VehicleClassDictServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.general.BranchEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.general.CityEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.general.CompanyActivityKindEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.general.InsuranceCompanyEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.general.SubjectCompanyEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.general.SubjectEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.general.SubjectPersonEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.general.UserEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.osgpovts.PolicyEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.osgpovts.VehicleEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.osgpovts.VehicleManufacturerEntityServiceWS;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.osgpovts.VehicleModelEntityServiceWS;
import kz.theeurasia.esbdproxy.services.general.BranchServiceDAO;
import kz.theeurasia.esbdproxy.services.general.CancelationReasonServiceDAO;
import kz.theeurasia.esbdproxy.services.general.CityServiceDAO;
import kz.theeurasia.esbdproxy.services.general.CompanyActivityKindServiceDAO;
import kz.theeurasia.esbdproxy.services.general.CountryRegionServiceDAO;
import kz.theeurasia.esbdproxy.services.general.CountryServiceDAO;
import kz.theeurasia.esbdproxy.services.general.EconomicSectorServiceDAO;
import kz.theeurasia.esbdproxy.services.general.IdentityCardTypeServiceDAO;
import kz.theeurasia.esbdproxy.services.general.InsuranceCompanyServiceDAO;
import kz.theeurasia.esbdproxy.services.general.KZCityServiceDAO;
import kz.theeurasia.esbdproxy.services.general.MaritalStatusServiceDAO;
import kz.theeurasia.esbdproxy.services.general.SexServiceDAO;
import kz.theeurasia.esbdproxy.services.general.SubjectCompanyServiceDAO;
import kz.theeurasia.esbdproxy.services.general.SubjectPersonServiceDAO;
import kz.theeurasia.esbdproxy.services.general.SubjectServiceDAO;
import kz.theeurasia.esbdproxy.services.general.UserServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.InsuranceClassTypeServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.InsuredAgeExpirienceClassServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.PolicyServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleAgeClassServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleClassServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleManufacturerServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleModelServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleServiceDAO;

public abstract class GeneralServiceTestCase {
    private static final String ESBD_DATE_FORMAT_PATTERN = "dd.MM.yyyy";
    private static final DateFormat ESBD_DATE_FORMATER = new SimpleDateFormat(ESBD_DATE_FORMAT_PATTERN);

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

    protected CityServiceDAO getCityService() throws NamingException {
	return (CityServiceDAO) context.lookup(nameFor(CityEntityServiceWS.class));
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

    protected KZCityServiceDAO getKZCityServiceDictWS() throws NamingException {
	return (KZCityServiceDAO) context.lookup(nameFor(KZCityDictServiceWS.class));
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

    protected VehicleManufacturerServiceDAO getVehicleManufacturerServiceEntityWS() throws NamingException {
	return (VehicleManufacturerServiceDAO) context.lookup(nameFor(VehicleManufacturerEntityServiceWS.class));
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

    protected Calendar convertESBDDateToCalendar(String esbdDate) {
	if (esbdDate == null || esbdDate.trim().equals(""))
	    return null;
	try {
	    Calendar date = Calendar.getInstance();
	    date.setTime(ESBD_DATE_FORMATER.parse(esbdDate));
	    return date;
	} catch (ParseException e) {
	    e.printStackTrace();
	    return null;
	}
    }

    protected Date convertESBDDateToDate(String esbdDate) {
	if (esbdDate == null || esbdDate.trim().equals(""))
	    return null;
	try {
	    return ESBD_DATE_FORMATER.parse(esbdDate);
	} catch (ParseException e) {
	    e.printStackTrace();
	    return null;
	}
    }

    protected String convertCalendarToESBDDate(Calendar calendar) {
	if (calendar == null)
	    return null;
	return convertDateToESBDDate(calendar.getTime());
    }

    protected String convertDateToESBDDate(Date date) {
	if (date == null)
	    return null;
	return ESBD_DATE_FORMATER.format(date);
    }
}
