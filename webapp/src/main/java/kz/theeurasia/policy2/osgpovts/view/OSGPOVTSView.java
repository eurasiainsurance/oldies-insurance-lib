package kz.theeurasia.policy2.osgpovts.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import kz.theeurasia.policy2.osgpovts.domain.Insurant;
import kz.theeurasia.policy2.osgpovts.domain.Insured;
import kz.theeurasia.policy2.osgpovts.domain.Vehicle;
import kz.theeurasia.policy2.osgpovts.facade.CalculatorFacade;
import kz.theeurasia.services.domain.global.CountryRegion;
import kz.theeurasia.services.domain.osgpovts.DriverExpirienceClass;
import kz.theeurasia.services.domain.osgpovts.InsuredAgeClass;
import kz.theeurasia.services.domain.osgpovts.PolicyTermClass;
import kz.theeurasia.services.domain.osgpovts.VehicleAgeClass;
import kz.theeurasia.services.domain.osgpovts.VehicleClass;

@ManagedBean(name = "osgpovtsView")
@ViewScoped
public class OSGPOVTSView implements Serializable {

    private static final long serialVersionUID = 6605204552704504011L;

    @ManagedProperty("#{glb}")
    private ResourceBundle glb;

    private Insurant insurant;
    private List<Insured> insuredList;
    private List<Vehicle> vehicleList;
    private PolicyTermClass policyTermClass = PolicyTermClass.YEAR;

    private double premiumCost;

    @ManagedProperty("#{calculatorFacade}")
    private CalculatorFacade calculatorFacade;

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

    public void setCalcServ(CalculatorFacade calculatorFacade) {
	this.calculatorFacade = calculatorFacade;
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
	calculatorFacade.validate(insuredList.toArray(new Insured[0]),
		vehicleList.toArray(new Vehicle[0]), policyTermClass);
	premiumCost = calculatorFacade.calculate(insuredList.toArray(new Insured[0]),
		vehicleList.toArray(new Vehicle[0]), policyTermClass);
    }

}
