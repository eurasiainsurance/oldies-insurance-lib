package kz.theeurasia.policy.osgpovts.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import kz.theeurasia.policy.GlobalMessages;
import kz.theeurasia.policy.osgpovts.domain.Insured;
import kz.theeurasia.policy.osgpovts.domain.Vehicle;
import kz.theeurasia.services.domain.esbd.ClientInfo;
import kz.theeurasia.services.domain.global.CountryRegion;
import kz.theeurasia.services.domain.global.IdNumber;
import kz.theeurasia.services.domain.global.InsuranceClassType;
import kz.theeurasia.services.domain.osgpovts.DriverExpirienceClass;
import kz.theeurasia.services.domain.osgpovts.InsuredAgeClass;
import kz.theeurasia.services.domain.osgpovts.InsuredInfo;
import kz.theeurasia.services.domain.osgpovts.PolicyTermClass;
import kz.theeurasia.services.domain.osgpovts.VehicleAgeClass;
import kz.theeurasia.services.domain.osgpovts.VehicleClass;
import kz.theeurasia.services.domain.osgpovts.VehicleInfo;
import kz.theeurasia.services.services.ESBDAccess;
import kz.theeurasia.services.services.ESBDException;
import kz.theeurasia.services.services.ESBDFaultException;
import kz.theeurasia.services.services.NotFound;
import kz.theeurasia.services.services.OSGPOVTSCalculator;

@ManagedBean
@ViewScoped
public class CalculatorView implements Serializable {

    private static final long serialVersionUID = -1581967628944479567L;

    @EJB
    private OSGPOVTSCalculator calculatorService;

    @EJB
    private ESBDAccess esbdAccessService;

    @ManagedProperty("#{glb}")
    private ResourceBundle glb;

    public void setGlb(ResourceBundle glb) {
	this.glb = glb;
    }

    private List<Insured> insuredList;
    private List<Vehicle> vehicleList;
    private PolicyTermClass policyTermClass = PolicyTermClass.YEAR;

    private double premiumCost;

    @PostConstruct
    public void cleanInit() {
	insuredList = new ArrayList<>();
	addInsured();

	vehicleList = new ArrayList<>();
	addVehicle();
    }

    public List<Insured> getInsuredList() {
	return insuredList;
    }

    public Insured addInsured() {
	Insured insured = new Insured(InsuredAgeClass.OVER25, DriverExpirienceClass.MORE2, "", false, null, null);
	insuredList.add(insured);
	return insured;
    }

    public void removeInsured(Insured insured) {
	insuredList.remove(insured);
    }

    public List<Vehicle> getVehicleList() {
	return vehicleList;
    }

    public Vehicle addVehicle() {
	Vehicle vehicle = new Vehicle(CountryRegion.GALM, true, VehicleClass.CAR, VehicleAgeClass.UNDER7, true);
	vehicleList.add(vehicle);
	return vehicle;
    }

    public void removeVehicle(Vehicle vehicle) {
	vehicleList.remove(vehicle);
    }

    public PolicyTermClass getPolicyTermClass() {
	return policyTermClass;
    }

    public void setPolicyTermClass(PolicyTermClass policyTermClass) {
	this.policyTermClass = policyTermClass;
    }

    public double getPremiumCost() {
	return premiumCost;
    }

    private void _calculateByManyInsured() throws ESBDException {
	List<InsuredInfo> insuredInfos = new ArrayList<>();
	for (Insured insured : insuredList) {
	    InsuredInfo insuredInfo = new InsuredInfo(insured.getInsuredAgeClass(), insured.getDriverExpirienceClass(),
		    insured.getInsuranceClassType(),
		    insured.isHasPrivilege());
	    insuredInfos.add(insuredInfo);
	}
	Vehicle vehicle = vehicleList.iterator().next();
	VehicleInfo vehicleInfo = new VehicleInfo(vehicle.getRegion(), vehicle.isMajorCity(), vehicle.getVehicleClass(),
		vehicle.getAgeClass());
	premiumCost = calculatorService.calculatePremium(insuredInfos.toArray(new InsuredInfo[0]), vehicleInfo,
		policyTermClass);
    }

    private void _calculateByManyVehicle() throws ESBDException {
	Insured insured = insuredList.iterator().next();
	InsuredInfo insuredInfo = new InsuredInfo(insured.getInsuredAgeClass(), insured.getDriverExpirienceClass(),
		insured.getInsuranceClassType(),
		insured.isHasPrivilege());

	List<VehicleInfo> vehicleInfos = new ArrayList<>();
	for (Vehicle vehicle : vehicleList) {
	    VehicleInfo vehicleInfo = new VehicleInfo(vehicle.getRegion(), vehicle.isMajorCity(),
		    vehicle.getVehicleClass(),
		    vehicle.getAgeClass());
	    vehicleInfos.add(vehicleInfo);
	}
	premiumCost = calculatorService.calculatePremium(insuredInfo, vehicleInfos.toArray(new VehicleInfo[0]),
		policyTermClass);
    }

    private void _prepareInsured() throws ESBDException, ESBDFaultException {
	for (Insured insured : insuredList) {
	    try {
		InsuranceClassType classType = esbdAccessService
			.getInsuranceClassTypeForIndividual(new IdNumber(insured.getIdNumber()));
		insured.setInsuranceClassType(classType);
		ClientInfo clientInfo = esbdAccessService.getClientInfo(new IdNumber(insured.getIdNumber()));
		insured.setClientInfo(clientInfo);
	    } catch (NotFound e) {
		insured.setInsuranceClassType(InsuranceClassType.DEFAULT);
		insured.setClientInfo(null);
	    }
	}
    }

    public void checkMajorCityForced(Vehicle vehicle) {
	vehicle.setMajorCityTrueForced(
		vehicle.getRegion().equals(CountryRegion.GALM) || vehicle.getRegion().equals(CountryRegion.GAST));
	if (vehicle.isMajorCityTrueForced())
	    vehicle.setMajorCity(true);
    }

    public void doCalculate() {
	try {
	    _prepareInsured();
	    if (vehicleList.size() > 1)
		_calculateByManyVehicle();
	    else
		_calculateByManyInsured();
	} catch (ESBDException | ESBDFaultException e) {
	    FacesContext
		    .getCurrentInstance()
		    .addMessage(null,
			    new FacesMessage(FacesMessage.SEVERITY_FATAL,
				    glb.getString(GlobalMessages.MESSAGES_SERVER_FATAL_ERROR_CAPTION),
				    glb.getString(GlobalMessages.MESSAGES_SERVER_FATAL_ERROR_DESCRIPTION)));
	}
    }

}
