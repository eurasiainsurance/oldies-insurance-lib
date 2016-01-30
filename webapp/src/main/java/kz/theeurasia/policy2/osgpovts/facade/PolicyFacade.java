package kz.theeurasia.policy2.osgpovts.facade;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import kz.theeurasia.esbdproxy.domain.dict.CountryRegionDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuredAgeExpirienceClassDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleAgeClassDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.domain.entities.SubjectPersonEntity;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.InsuredDriverEntity;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.InsuredVehicleEntity;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.PolicyEntity;

@ManagedBean
@ViewScoped
public class PolicyFacade {

    public PolicyEntity createNew() {
	PolicyEntity policy = new PolicyEntity();
	addInsuredDriver(policy);
	addInsuredVehicle(policy);

	return policy;
    }

    public InsuredVehicleEntity addInsuredVehicle(PolicyEntity policy) {
	InsuredVehicleEntity e = new InsuredVehicleEntity();
	e.setPolicy(policy);
	policy.getInsuredVehicles().add(e);

	e.setVehicleClass(VehicleClassDict.CAR);
	e.getCertificate().setRegistrationRegion(CountryRegionDict.GALM);
	e.getCertificate().setMajorCity(true);
	e.setVehicleAgeClass(VehicleAgeClassDict.UNDER7);

	return e;
    }

    public void removeInsuredVehicle(PolicyEntity policy, InsuredVehicleEntity vehicle) {
	policy.getInsuredVehicles().remove(vehicle);
    }

    public InsuredDriverEntity addInsuredDriver(PolicyEntity policy) {
	InsuredDriverEntity e = new InsuredDriverEntity();
	e.setPolicy(policy);
	policy.getInsuredDrivers().add(e);
	e.setInsuredAgeExpirienceClass(InsuredAgeExpirienceClassDict.OVER25_MORE2);
	SubjectPersonEntity insuredPerson = new SubjectPersonEntity(); 
	e.setInsuredPerson(insuredPerson);
	return e;
    }

    public void removeInsuredDriver(PolicyEntity policy, InsuredDriverEntity driver) {
	policy.getInsuredDrivers().remove(driver);
    }
}
