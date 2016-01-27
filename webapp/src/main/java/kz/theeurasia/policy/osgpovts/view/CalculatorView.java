package kz.theeurasia.policy.osgpovts.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import kz.theeurasia.policy.GlobalMessages;
import kz.theeurasia.policy.osgpovts.domain.Insurant;
import kz.theeurasia.policy.osgpovts.domain.Insured;
import kz.theeurasia.policy.osgpovts.domain.Vehicle;
import kz.theeurasia.policy.osgpovts.services.CalculatorService;
import kz.theeurasia.services.domain.global.CountryRegion;
import kz.theeurasia.services.domain.osgpovts.DriverExpirienceClass;
import kz.theeurasia.services.domain.osgpovts.InsuredAgeClass;
import kz.theeurasia.services.domain.osgpovts.PolicyTermClass;
import kz.theeurasia.services.domain.osgpovts.VehicleAgeClass;
import kz.theeurasia.services.domain.osgpovts.VehicleClass;
import kz.theeurasia.services.services.ESBDException;
import kz.theeurasia.services.services.ESBDFaultException;

@ManagedBean
@ViewScoped
public class CalculatorView implements Serializable {

    private static final long serialVersionUID = -1581967628944479567L;

    @ManagedProperty("#{glb}")
    private ResourceBundle glb;

    private Insurant insurant;
    private List<Insured> insuredList;
    private List<Vehicle> vehicleList;
    private PolicyTermClass policyTermClass = PolicyTermClass.YEAR;

    private double premiumCost;

    @ManagedProperty("#{calculatorService}")
    private CalculatorService calcServ;

    @PostConstruct
    public void cleanInit() {
	insurant = new Insurant();

	insuredList = new ArrayList<>();
	addInsured();

	vehicleList = new ArrayList<>();
	addVehicle();
    }

    public void setGlb(ResourceBundle glb) {
	this.glb = glb;
    }

    public void setCalcServ(CalculatorService calcServ) {
	this.calcServ = calcServ;
    }

    public Insurant getInsurant() {
	return insurant;
    }

    public void setInsurant(Insurant insurant) {
	this.insurant = insurant;
    }

    public List<Insured> getInsuredList() {
	return insuredList;
    }

    public Insured addInsured() {
	Insured insured = new Insured();
	insured.setInsuredAgeClass(InsuredAgeClass.OVER25);
	insured.setDriverExpirienceClass(DriverExpirienceClass.MORE2);
	insured.setHasPrivilege(false);
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
	Vehicle vehicle = new Vehicle();
	vehicle.setVehicleClass(VehicleClass.CAR);
	vehicle.setMajorCity(true);
	vehicle.setMajorCityTrueForced(true);
	vehicle.setRegion(CountryRegion.GALM);
	vehicle.setAgeClass(VehicleAgeClass.UNDER7);
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

    public void checkMajorCityForced(Vehicle vehicle) {
	vehicle.setMajorCityTrueForced(
		vehicle.getRegion().equals(CountryRegion.GALM) || vehicle.getRegion().equals(CountryRegion.GAST));
	if (vehicle.isMajorCityTrueForced())
	    vehicle.setMajorCity(true);
    }

    
    
    public void doCalculate() {
	try {
	    premiumCost = calcServ.calculate(insuredList, vehicleList, policyTermClass);
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
