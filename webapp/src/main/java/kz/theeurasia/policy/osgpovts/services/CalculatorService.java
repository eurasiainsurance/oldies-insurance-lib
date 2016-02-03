package kz.theeurasia.policy.osgpovts.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import kz.theeurasia.policy.osgpovts.domain.Insured;
import kz.theeurasia.policy.osgpovts.domain.Vehicle;
import kz.theeurasia.services.domain.osgpovts.InsuredInfo;
import kz.theeurasia.services.domain.osgpovts.PolicyTermClass;
import kz.theeurasia.services.domain.osgpovts.VehicleInfo;
import kz.theeurasia.services.services.ESBDAccess;
import kz.theeurasia.services.services.ESBDException;
import kz.theeurasia.services.services.ESBDFaultException;
import kz.theeurasia.services.services.OSGPOVTSCalculator;

@ManagedBean
@ApplicationScoped
public class CalculatorService {
    @EJB
    private OSGPOVTSCalculator calculatorService;

    @EJB
    private ESBDAccess esbdAccessService;

    private double _calculateByManyInsured(List<Insured> insuredList, List<Vehicle> vehicleList,
	    PolicyTermClass policyTermClass) throws ESBDException {
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
	return calculatorService.calculatePremium(insuredInfos.toArray(new InsuredInfo[0]), vehicleInfo,
		policyTermClass);
    }

    private double _calculateByManyVehicle(List<Insured> insuredList, List<Vehicle> vehicleList,
	    PolicyTermClass policyTermClass) throws ESBDException {
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
	return calculatorService.calculatePremium(insuredInfo, vehicleInfos.toArray(new VehicleInfo[0]),
		policyTermClass);
    }

//    private void _prepareInsured(List<Insured> insuredList) throws ESBDException, ESBDFaultException {
//	for (Insured insured : insuredList) {
//	    try {
//		InsuranceClassType classType = esbdAccessService
//			.getInsuranceClassTypeForIndividual(new IdNumber(insured.getIdNumber()));
//		insured.setInsuranceClassType(classType);
//		ClientInfo clientInfo = esbdAccessService.getClientInfo(new IdNumber(insured.getIdNumber()));
//		insured.setClient(clientInfo);
//	    } catch (NotFound e) {
//		insured.setInsuranceClassType(InsuranceClassType.DEFAULT);
//		insured.setClient(null);
//	    }
//	}
//    }

    public double calculate(List<Insured> insuredList, List<Vehicle> vehicleList, PolicyTermClass policyTermClass) throws ESBDException, ESBDFaultException {
//	_prepareInsured(insuredList);
	if (vehicleList.size() > 1)
	    return _calculateByManyVehicle(insuredList, vehicleList, policyTermClass);
	else
	    return _calculateByManyInsured(insuredList, vehicleList, policyTermClass);
    }

}
