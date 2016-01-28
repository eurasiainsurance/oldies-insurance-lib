package kz.theeurasia.policy2.osgpovts.facade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import kz.theeurasia.policy2.osgpovts.domain.Insured;
import kz.theeurasia.policy2.osgpovts.domain.Vehicle;
import kz.theeurasia.services.domain.osgpovts.PolicyTermClass;
import kz.theeurasia.services.services.OSGPOVTSRates;

@ManagedBean
public class CalculatorFacade {

    @EJB
    private OSGPOVTSRates rates;
    
    
    public boolean validate(Insured[] insureds, Vehicle[] vehicles, PolicyTermClass termClass) {
	return true;
    }

    public double calculate(Insured[] insureds, Vehicle[] vehicles, PolicyTermClass termClass) {
	double premium = 0;
	
	
	return premium;
    }
}
