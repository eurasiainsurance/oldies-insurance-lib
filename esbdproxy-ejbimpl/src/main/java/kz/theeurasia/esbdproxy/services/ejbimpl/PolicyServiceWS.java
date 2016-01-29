package kz.theeurasia.esbdproxy.services.ejbimpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.ArrayOfDriver;
import kz.theeurasia.asb.esbd.jaxws.ArrayOfPoliciesTF;
import kz.theeurasia.asb.esbd.jaxws.Driver;
import kz.theeurasia.asb.esbd.jaxws.PoliciesTF;
import kz.theeurasia.asb.esbd.jaxws.Policy;
import kz.theeurasia.esbdproxy.domain.dict.CancelationReasonDict;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.InsuredDriverEntity;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.InsuredVehicleEntity;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.PolicyEntity;
import kz.theeurasia.esbdproxy.domain.infos.RecordOperationInfo;
import kz.theeurasia.esbdproxy.domain.infos.VehicleCertificateInfo;
import kz.theeurasia.esbdproxy.domain.infos.osgpovts.CertificateInfo;
import kz.theeurasia.esbdproxy.domain.infos.osgpovts.GPWParticipantInfo;
import kz.theeurasia.esbdproxy.domain.infos.osgpovts.InvalidInfo;
import kz.theeurasia.esbdproxy.domain.infos.osgpovts.PensionerInfo;
import kz.theeurasia.esbdproxy.domain.infos.osgpovts.PrivilegerInfo;
import kz.theeurasia.esbdproxy.services.BranchServiceDAO;
import kz.theeurasia.esbdproxy.services.CancelationReasonTypeServiceDAO;
import kz.theeurasia.esbdproxy.services.ClientServiceDAO;
import kz.theeurasia.esbdproxy.services.CountryRegionServiceDAO;
import kz.theeurasia.esbdproxy.services.IndividualServiceDAO;
import kz.theeurasia.esbdproxy.services.InsuranceCompanyServiceDAO;
import kz.theeurasia.esbdproxy.services.MaritalStatusServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.PolicyServiceDAO;
import kz.theeurasia.esbdproxy.services.UserServiceDAO;
import kz.theeurasia.esbdproxy.services.VehicleServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.DriverExpirienceClassificationServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.InsuranceClassTypeServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleAgeClassServiceDAO;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleClassServiceDAO;

@Singleton
public class PolicyServiceWS extends ESBDServiceWS implements PolicyServiceDAO {

    @EJB
    private InsuranceCompanyServiceDAO insuranceCompanyService;

    @EJB
    private ClientServiceDAO clientService;

    @EJB
    private CancelationReasonTypeServiceDAO cancelationReasonTypeService;

    @EJB
    private BranchServiceDAO branchService;

    @EJB
    private DriverExpirienceClassificationServiceDAO driverExpirienceClassificationService;

    @EJB
    private InsuranceClassTypeServiceDAO insuranceClassTypeService;

    @EJB
    private IndividualServiceDAO individualService;

    @EJB
    private MaritalStatusServiceDAO maritalStatusService;

    @EJB
    private UserServiceDAO userService;

    @EJB
    private VehicleServiceDAO vehicleService;

    @EJB
    private VehicleClassServiceDAO vehicleClassService;

    @EJB
    private VehicleAgeClassServiceDAO vehicleAgeClassService;

    @EJB
    private CountryRegionServiceDAO countryRegionService;

    @Override
    public PolicyEntity getById(Long id) throws NotFound {
	checkSession();
	Policy source = getSoapService().getPolicyByID(getSessionId(), new Long(id).intValue());
	if (source == null)
	    throw new NotFound("Not found with ID = '" + id + "'");
	PolicyEntity target = new PolicyEntity();
	fillValues(source, target);
	return target;
    }

    void fillValues(Policy source, PolicyEntity target) {
	target.setId(source.getPOLICYID());
	target.setNumber(source.getPOLICYNUMBER());
	target.setValidFrom(convertESBDDateToCalendar(source.getDATEBEG()));
	target.setValidTill(convertESBDDateToCalendar(source.getDATEEND()));
	target.setActualPremiumCost(source.getPREMIUM());
	target.setPremiumCost(source.getCALCULATEDPREMIUM());

	try {
	    target.setInsurer(insuranceCompanyService.getById(new Long(source.getSYSTEMDELIMITERID())));
	} catch (NotFound e) {
	    // mandatory field
	    throw new DataCoruptionException(
		    "Error while fetching Policy ID = '" + source.getPOLICYID()
			    + "' from ESBD. Insurance company ID = '" + source.getSYSTEMDELIMITERID()
			    + "' not found",
		    e);
	}

	try {
	    target.setInsurant(clientService.getById(new Long(source.getCLIENTID())));
	} catch (NotFound e) {
	    // mandatory field
	    throw new DataCoruptionException(
		    "Error while fetching Policy ID = '" + source.getPOLICYID() + "' from ESBD. Insurer ID = '"
			    + source.getCLIENTID() + "' not found",
		    e);
	}

	target.setDateOfIssue(convertESBDDateToCalendar(source.getPOLICYDATE()));
	target.setDateOfCancelation(convertESBDDateToCalendar(source.getRESCINDINGDATE()));

	try {
	    target.setCancelationReasonType(
		    cancelationReasonTypeService.getById(new Long(source.getRESCINDINGREASONID())));
	} catch (NotFound e) {
	    target.setCancelationReasonType(CancelationReasonDict.UNSPECIFIED);
	}

	try {
	    target.setBranch(branchService.getById(new Long(source.getBRANCHID())));
	} catch (NotFound e) {
	    // mandatory field
	    throw new DataCoruptionException(
		    "Error while fetching Policy from ESBD. Branch ID = '" + source.getBRANCHID() + "' not found", e);
	}

	target.setComments(source.getDESCRIPTION());

	ArrayOfDriver drivers = source.getDrivers();
	if (drivers == null)
	    throw new DataCoruptionException(
		    "Error while fetching Policy ID = '" + source.getPOLICYID() + "' from ESBD. Drivers list is empty");
	List<InsuredDriverEntity> insuredDrivers = new ArrayList<>();
	target.setInsuredDrivers(insuredDrivers);
	for (Driver s : drivers.getDriver()) {
	    InsuredDriverEntity t = new InsuredDriverEntity();
	    fillValues(s, t, target);
	    insuredDrivers.add(t);
	}

	ArrayOfPoliciesTF vehicles = source.getPoliciesTF();
	if (vehicles == null)
	    throw new DataCoruptionException(
		    "Error while fetching Policy ID = '" + source.getPOLICYID()
			    + "' from ESBD. Insured vehicle list is empty");
	List<InsuredVehicleEntity> insuredVehicles = new ArrayList<>();
	target.setInsuredVehicles(insuredVehicles);
	for (PoliciesTF s : vehicles.getPoliciesTF()) {
	    InsuredVehicleEntity t = new InsuredVehicleEntity();
	    fillValues(s, t, target);
	    insuredVehicles.add(t);
	}
    }

    void fillValues(Driver source, InsuredDriverEntity target, PolicyEntity policy) {
	target.setId(source.getDRIVERID());
	if (policy.getId() == source.getPOLICYID())
	    target.setPolicy(policy);
	else {
	    try {
		target.setPolicy(getById(new Long(source.getPOLICYID())));
	    } catch (NotFound e) {
		throw new DataCoruptionException(
			"Error while fetching Driver ID = '" + source.getDRIVERID()
				+ "' at Policy ID = '" + source.getPOLICYID()
				+ "' from ESBD. Policty with ID = '" + source.getPOLICYID() + "' not found");
	    }
	}

	try {
	    target.setInsuredDriverExpirienceClass(
		    driverExpirienceClassificationService.getById(new Long(source.getAGEEXPERIENCEID())));
	} catch (NotFound e) {
	    throw new DataCoruptionException(
		    "Error while fetching Driver ID = '" + source.getDRIVERID()
			    + "' at Policy ID = '" + source.getPOLICYID()
			    + "' from ESBD. AGEEXPIRIENCE with ID = '" + source.getAGEEXPERIENCEID() + "' not found");
	}

	target.setDrivingExpirience(source.getEXPERIENCE());

	try {
	    target.setInsuraceClassType(insuranceClassTypeService.getById(new Long(source.getClassId())));
	} catch (NotFound e) {
	    // TODO is mandatory?
	    throw new DataCoruptionException(
		    "Error while fetching Driver ID = '" + source.getDRIVERID()
			    + "' at Policy ID = '" + source.getPOLICYID()
			    + "' from ESBD. Class Type with ID = '" + source.getClassId() + "' not found");
	}

	try {
	    target.setInsuredPerson(individualService.getById(new Long(source.getCLIENTID())));
	} catch (NotFound e) {
	    throw new DataCoruptionException(
		    "Error while fetching Driver ID = '" + source.getDRIVERID()
			    + "' at Policy ID = '" + source.getPOLICYID()
			    + "' from ESBD. CLIENT (individual) with ID = '" + source.getCLIENTID()
			    + "' not found",
		    e);
	}

	try {
	    target.setMaritalStatus(maritalStatusService.getById(new Long(source.getHOUSEHOLDPOSITIONID())));
	} catch (NotFound e) {
	    throw new DataCoruptionException(
		    "Error while fetching Driver ID = '" + source.getDRIVERID()
			    + "' at Policy ID = '" + source.getPOLICYID()
			    + "' from ESBD. Marital Status ID = '" + source.getHOUSEHOLDPOSITIONID()
			    + "' not found",
		    e);
	}

	CertificateInfo dl = new CertificateInfo(source.getDRIVERCERTIFICATE(),
		convertESBDDateToCalendar(source.getDRIVERCERTIFICATEDATE()));
	target.setDriverLicense(dl);

	PrivilegerInfo pi = new PrivilegerInfo();
	target.setPrivilegerInfo(pi);
	target.setPrivileger(source.getPRIVELEGERBOOL() == 1);
	if (target.isPrivileger()) {
	    pi.setType(source.getPRIVELEDGERTYPE());
	    pi.setCertificateNumber(source.getPRIVELEDGERCERTIFICATE());
	    pi.setCertificateDateOfIssue(convertESBDDateToCalendar(source.getPRIVELEDGERCERTIFICATEDATE()));
	}

	InvalidInfo ii = new InvalidInfo();
	target.setInvalidInfo(ii);
	target.setInvalid(source.getINVALIDBOOL() == 1);
	if (target.isInvalid()) {
	    ii.setCertificateNumber(source.getINVALIDCERTIFICATE());
	    ii.setCertificateValidFrom(convertESBDDateToCalendar(source.getINVALIDCERTIFICATEBEGDATE()));
	    ii.setCertificateValidTill(convertESBDDateToCalendar(source.getINVALIDCERTIFICATEENDDATE()));
	}

	PensionerInfo pei = new PensionerInfo();
	target.setPensionerInfo(pei);
	target.setPensioner(source.getPENSIONERBOOL() == 1);
	if (target.isPensioner()) {
	    pei.setCertificateNumber(source.getPENSIONERCERTIFICATE());
	    pei.setCertiticateDateOfIssue(convertESBDDateToCalendar(source.getPENSIONERCERTIFICATEDATE()));
	}

	GPWParticipantInfo gpwi = new GPWParticipantInfo();
	target.setGpwParticipantInfo(gpwi);
	target.setGpwParticipant(source.getWOWBOOL() == 1);
	if (target.isGpwParticipant()) {
	    gpwi.setCertificateNumber(source.getWOWCERTIFICATE());
	    gpwi.setCertificateDateOfIssue(convertESBDDateToCalendar(source.getWOWCERTIFICATEDATE()));
	}

	RecordOperationInfo created = new RecordOperationInfo();
	target.setCreated(created);
	created.setDate(convertESBDDateToCalendar(source.getINPUTDATE()));
	try {
	    created.setAuthor(userService.getById(new Long(source.getCREATEDBYUSERID())));
	} catch (NotFound e) {
	    throw new DataCoruptionException(
		    "Error while fetching Driver ID = '" + source.getDRIVERID()
			    + "' at Policy ID = '" + source.getPOLICYID()
			    + "' from ESBD. Created User ID = '" + source.getCREATEDBYUSERID()
			    + "' not found",
		    e);
	}

	RecordOperationInfo modified = new RecordOperationInfo();
	target.setModified(modified);
	modified.setDate(convertESBDDateToCalendar(source.getRECORDCHANGEDAT()));
	if (modified.getDate() != null)
	    try {
		modified.setAuthor(userService.getById(new Long(source.getCHANGEDBYUSERID())));
	    } catch (NotFound e) {
		throw new DataCoruptionException(
			"Error while fetching Driver ID = '" + source.getDRIVERID()
				+ "' at Policy ID = '" + source.getPOLICYID()
				+ "' from ESBD. Modified User ID = '" + source.getCHANGEDBYUSERID()
				+ "' not found",
			e);
	    }

	try {
	    target.setInsurer(insuranceCompanyService.getById(new Long(source.getSYSTEMDELIMITERID())));
	} catch (NotFound e) {
	    throw new DataCoruptionException(
		    "Error while fetching Driver ID = '" + source.getDRIVERID()
			    + "' at Policy ID = '" + source.getPOLICYID()
			    + "' from ESBD. Insurance company ID = '" + source.getSYSTEMDELIMITERID()
			    + "' not found",
		    e);
	}

    }

    void fillValues(PoliciesTF source, InsuredVehicleEntity target, PolicyEntity policy) {
	// POLICY_TF_ID s:int Идентификатор ТС полиса
	target.setId(source.getPOLICYTFID());

	// POLICY_ID s:int Идентификатор полиса
	if (policy.getId() == source.getPOLICYID())
	    target.setPolicy(policy);
	else {
	    try {
		target.setPolicy(getById(new Long(source.getPOLICYID())));
	    } catch (NotFound e) {
		throw new DataCoruptionException(
			"Error while fetching InsuredVehicle ID = '" + source.getPOLICYTFID()
				+ "' at Policy ID = '" + source.getPOLICYID()
				+ "' from ESBD. Policty with ID = '" + source.getPOLICYID() + "' not found",
			e);
	    }
	}

	// TF_ID s:int Идентификатор ТС
	try {
	    target.setVehicle(vehicleService.getById(new Long(source.getTFID())));
	} catch (NotFound e) {
	    // TODO is mandatory?
	    throw new DataCoruptionException(
		    "Error while fetching InsuredVehicle ID = '" + source.getPOLICYTFID()
			    + "' at Policy ID = '" + source.getPOLICYID()
			    + "' from ESBD. Vehicle with ID = '" + source.getTFID() + "' not found",
		    e);
	}

	// TF_TYPE_ID s:int Идентификатор типа ТС (обязательно)
	try {
	    target.setVehicleClass(vehicleClassService.getById(new Long(source.getTFTYPEID())));
	} catch (NotFound e) {
	    throw new DataCoruptionException(
		    "Error while fetching InsuredVehicle ID = '" + source.getPOLICYTFID()
			    + "' at Policy ID = '" + source.getPOLICYID()
			    + "' from ESBD. VehicleType with ID = '" + source.getTFTYPEID() + "' not found",
		    e);
	}

	// TF_AGE_ID s:int Идентификатор возраста ТС (обязательно)
	try {
	    target.setVehicleAgeClass(vehicleAgeClassService.getById(new Long(source.getTFAGEID())));
	} catch (NotFound e) {
	    throw new DataCoruptionException(
		    "Error while fetching InsuredVehicle ID = '" + source.getPOLICYTFID()
			    + "' at Policy ID = '" + source.getPOLICYID()
			    + "' from ESBD. VehicleAgeType with ID = '" + source.getTFAGEID() + "' not found",
		    e);
	}

	// TF_NUMBER s:string Гос. номер ТС
	// TF_REGISTRATION_CERTIFICATE s:string Номер тех. паспорта
	// GIVE_DATE s:string Дата выдачи тех. паспорта
	// REGION_ID s:int Идентификатор региона регистрации ТС (обязательно)
	// BIG_CITY_BOOL s:int Признак города областного значения (обязательно)
	VehicleCertificateInfo vci = new VehicleCertificateInfo();
	target.setCertificate(vci);

	vci.setRegistrationNumber(source.getTFNUMBER());
	vci.setCertificateNumber(source.getTFREGISTRATIONCERTIFICATE());
	vci.setDateOfIssue(convertESBDDateToCalendar(source.getGIVEDATE()));
	vci.setMajorCity(source.getBIGCITYBOOL() == 1);
	try {
	    vci.setRegistrationRegion(countryRegionService.getById(new Long(source.getREGIONID())));
	} catch (NotFound e) {
	    throw new DataCoruptionException(
		    "Error while fetching InsuredVehicle ID = '" + source.getPOLICYTFID()
			    + "' at Policy ID = '" + source.getPOLICYID()
			    + "' from ESBD. Vehicle Registration region with ID = '" + source.getREGIONID()
			    + "' not found",
		    e);
	}

	// PURPOSE s:string Цель использования ТС
	target.setVehiclePurpose(source.getPURPOSE());

	// ODOMETER s:int Показания одометра
	target.setCurrentOdometerValue(source.getODOMETER());

	// CREATED_BY_USER_ID s:int Идентификатор пользователя, создавшего
	// запись
	// INPUT_DATE s:string Дата\время ввода записи в систему
	RecordOperationInfo created = new RecordOperationInfo();
	target.setCreated(created);
	created.setDate(convertESBDDateToCalendar(source.getINPUTDATE()));
	try {
	    created.setAuthor(userService.getById(new Long(source.getCREATEDBYUSERID())));
	} catch (NotFound e) {
	    throw new DataCoruptionException(
		    "Error while fetching InsuredVehicle ID = '" + source.getPOLICYTFID()
			    + "' at Policy ID = '" + source.getPOLICYID()
			    + "' from ESBD. Created User ID = '" + source.getCREATEDBYUSERID()
			    + "' not found",
		    e);
	}

	// RECORD_CHANGED_AT s:string Дата\время изменения записи
	// CHANGED_BY_USER_ID s:int Идентификатор пользователя, изменившего
	// запись
	RecordOperationInfo modified = new RecordOperationInfo();
	target.setModified(modified);
	modified.setDate(convertESBDDateToCalendar(source.getRECORDCHANGEDAT()));
	if (modified.getDate() != null)
	    try {
		modified.setAuthor(userService.getById(new Long(source.getCHANGEDBYUSERID())));
	    } catch (NotFound e) {
		throw new DataCoruptionException(
			"Error while fetching InsuredVehicle ID = '" + source.getPOLICYTFID()
				+ "' at Policy ID = '" + source.getPOLICYID()
				+ "' from ESBD. Modified User ID = '" + source.getCHANGEDBYUSERID()
				+ "' not found",
			e);
	    }

	// SYSTEM_DELIMITER_ID s:int Идентификатор страховой компании
	try {
	    target.setInsurer(insuranceCompanyService.getById(new Long(source.getSYSTEMDELIMITERID())));
	} catch (NotFound e) {
	    throw new DataCoruptionException(
		    "Error while fetching InsuredVehicle ID = '" + source.getPOLICYTFID()
			    + "' at Policy ID = '" + source.getPOLICYID()
			    + "' from ESBD. Insurance company ID = '" + source.getSYSTEMDELIMITERID()
			    + "' not found",
		    e);
	}

    }

}
