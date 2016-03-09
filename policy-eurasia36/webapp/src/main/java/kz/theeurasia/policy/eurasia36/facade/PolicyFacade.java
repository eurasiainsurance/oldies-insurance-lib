package kz.theeurasia.policy.eurasia36.facade;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import kz.theeurasia.policy.eurasia36.domain.PolicyRequestData;
import kz.theeurasia.policy.services.CalculationService;

@Named
@ViewScoped
public class PolicyFacade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CalculationService calculationService;

    public PolicyRequestData initNew() {
	PolicyRequestData policy = new PolicyRequestData();
	return policy;
    }

    public void calculatePremiumCost(PolicyRequestData data) {
	double cost = calculationService.calculatePremiumCost(data.getInsuredDrivers(), data.getInsuredVehicles(),
		data.getTermClass());
	data.setCalculatedPremiumCost(cost);
    }
}
