package kz.theeurasia.police.osgpovts.view;

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

import kz.theeurasia.police.Messages;
import kz.theeurasia.police.osgpovts.domain.Insured;
import kz.theeurasia.services.ESBDAccess;
import kz.theeurasia.services.ESBDException;
import kz.theeurasia.services.NotFound;
import kz.theeurasia.services.OSGPOVTSCalculator;
import kz.theeurasia.services.domain.AgeClass;
import kz.theeurasia.services.domain.ClientInfo;
import kz.theeurasia.services.domain.CountryRegion;
import kz.theeurasia.services.domain.DriverExpirienceClass;
import kz.theeurasia.services.domain.IdNumber;
import kz.theeurasia.services.domain.InsuranceClassType;
import kz.theeurasia.services.domain.InsuredInfo;
import kz.theeurasia.services.domain.PolicyTermClass;
import kz.theeurasia.services.domain.VehicleAgeClass;
import kz.theeurasia.services.domain.VehicleClass;

@ManagedBean
@ViewScoped
public class CalculatorView implements Serializable {

    private static final long serialVersionUID = -1581967628944479567L;

    @EJB
    private OSGPOVTSCalculator calculatorService;

    @EJB
    private ESBDAccess esbdAccessService;

    @ManagedProperty("#{msg}")
    private ResourceBundle bundle;

    public void setBundle(ResourceBundle bundle) {
	this.bundle = bundle;
    }

    private List<Insured> insuredList;
    private CountryRegion countryRegion;
    private boolean isMajorCity;
    private VehicleAgeClass vehicleAgeType;
    private VehicleClass vehicleType;
    private PolicyTermClass policyTermClass = PolicyTermClass.YEAR;

    private double premiumCost;

    @PostConstruct
    public void cleanInit() {
	insuredList = new ArrayList<>();
	addInsured();

	countryRegion = CountryRegion.GALM;
	isMajorCity = true;
	vehicleAgeType = VehicleAgeClass.UNDER7;
	vehicleType = VehicleClass.CAR;
    }

    public Insured addInsured() {
	Insured insured = new Insured(AgeClass.OVER25, DriverExpirienceClass.MORE2, "", false, null, null);
	insuredList.add(insured);
	return insured;
    }

    public void removeInsured(Insured insured) {
	insuredList.remove(insured);
    }

    public List<Insured> getInsuredList() {
	return insuredList;
    }

    public void setInsuredList(List<Insured> insuredList) {
	this.insuredList = insuredList;
    }

    public CountryRegion getCountryRegion() {
	return countryRegion;
    }

    public void setCountryRegion(CountryRegion countryRegion) {
	this.countryRegion = countryRegion;
    }

    public boolean isMajorCity() {
	return isMajorCity;
    }

    public void setMajorCity(boolean isMajorCity) {
	this.isMajorCity = isMajorCity;
    }

    public VehicleAgeClass getVehicleAgeType() {
	return vehicleAgeType;
    }

    public void setVehicleAgeType(VehicleAgeClass vehicleAgeType) {
	this.vehicleAgeType = vehicleAgeType;
    }

    public VehicleClass getVehicleType() {
	return vehicleType;
    }

    public void setVehicleType(VehicleClass vehicleType) {
	this.vehicleType = vehicleType;
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

    public void doCalculate() {
	try {
	    List<InsuredInfo> insuredInfos = new ArrayList<>();
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
		InsuredInfo ii = new InsuredInfo(insured.getAgeClass(), insured.getDriverExpirienceClass(),
			insured.getInsuranceClassType(),
			insured.isHasPrivilege());
		insuredInfos.add(ii);
	    }
	    premiumCost = calculatorService.calculatePremium(insuredInfos.toArray(new InsuredInfo[0]), countryRegion,
		    isMajorCity, vehicleType, vehicleAgeType, policyTermClass);
	} catch (ESBDException e) {
	    FacesContext
		    .getCurrentInstance()
		    .addMessage(null,
			    new FacesMessage(FacesMessage.SEVERITY_FATAL,
				    bundle.getString(Messages.MESSAGES_SERVER_FATAL_ERROR_CAPTION),
				    bundle.getString(Messages.MESSAGES_SERVER_FATAL_ERROR_DESCRIPTION)));
	}
    }

}
