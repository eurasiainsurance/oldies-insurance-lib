package kz.theeurasia.policy.osgpovts.view;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import kz.theeurasia.policy.GlobalMessageBundleCode;
import kz.theeurasia.policy.osgpovts.ValidationException;
import kz.theeurasia.policy.osgpovts.domain.InsuredDriver;
import kz.theeurasia.policy.osgpovts.domain.InsuredVehicle;
import kz.theeurasia.policy.osgpovts.domain.PolicyRequest;
import kz.theeurasia.policy.osgpovts.facade.PolicyRequestFacade;
import kz.theeurasia.policy.osgpovts.facade.PremiumCostCalculatorFacade;

@ManagedBean(name = "osgpovtsView")
@ViewScoped
public class OSGPOVTSView implements Serializable {

    private static final long serialVersionUID = 6605204552704504011L;

    @ManagedProperty("#{glb}")
    private ResourceBundle glb;

    @ManagedProperty("#{gpovts}")
    private ResourceBundle gpovts;

    @ManagedProperty("#{policyRequestFacade}")
    private PolicyRequestFacade policyRequestFacade;

    @ManagedProperty("#{premiumCostCalculatorFacade}")
    private PremiumCostCalculatorFacade premiumCostCalculatorFacade;

    private PolicyRequest policy;

    @PostConstruct
    public void init() {
	try {
	    this.policy = policyRequestFacade.initNew();
	} catch (ValidationException e) {
	    FacesContext
		    .getCurrentInstance()
		    .addMessage(null,
			    new FacesMessage(FacesMessage.SEVERITY_FATAL,
				    glb.getString(GlobalMessageBundleCode.MESSAGES_SERVER_FATAL_ERROR_CAPTION
					    .getMessageBundleCode()),
				    glb.getString(GlobalMessageBundleCode.MESSAGES_SERVER_FATAL_ERROR_DESCRIPTION
					    .getMessageBundleCode())));
	}
    }

    public void addInsuredDriver() {
	try {
	    policyRequestFacade.addInsuredDriver(policy);
	    premiumCostCalculatorFacade.calculatePremiumCost(policy);
	} catch (ValidationException e) {
	    FacesContext
		    .getCurrentInstance()
		    .addMessage(null,
			    new FacesMessage(FacesMessage.SEVERITY_WARN,
				    gpovts.getString(e.getMessageCode().getMessageBundleCode()),
				    gpovts.getString(e.getDescriptionCode().getMessageBundleCode())));
	}
    }

    public void removeInsuredDriver(InsuredDriver driver) {
	try {
	    policyRequestFacade.removeInsuredDriver(policy, driver);
	    premiumCostCalculatorFacade.calculatePremiumCost(policy);
	} catch (ValidationException e) {
	    FacesContext
		    .getCurrentInstance()
		    .addMessage(null,
			    new FacesMessage(FacesMessage.SEVERITY_WARN,
				    gpovts.getString(e.getMessageCode().getMessageBundleCode()),
				    gpovts.getString(e.getDescriptionCode().getMessageBundleCode())));
	}
    }

    public void addInsuredVehicle() {
	try {
	    policyRequestFacade.addInsuredVehicle(policy);
	    premiumCostCalculatorFacade.calculatePremiumCost(policy);
	} catch (ValidationException e) {
	    FacesContext
		    .getCurrentInstance()
		    .addMessage(null,
			    new FacesMessage(FacesMessage.SEVERITY_WARN,
				    gpovts.getString(e.getMessageCode().getMessageBundleCode()),
				    gpovts.getString(e.getDescriptionCode().getMessageBundleCode())));
	}
    }

    public void removeInsuredVehicle(InsuredVehicle insuredVehicle) {
	try {
	    policyRequestFacade.removeInsuredVehicle(policy, insuredVehicle);
	    premiumCostCalculatorFacade.calculatePremiumCost(policy);
	} catch (ValidationException e) {
	    FacesContext
		    .getCurrentInstance()
		    .addMessage(null,
			    new FacesMessage(FacesMessage.SEVERITY_WARN,
				    gpovts.getString(e.getMessageCode().getMessageBundleCode()),
				    gpovts.getString(e.getDescriptionCode().getMessageBundleCode())));
	}
    }

    public void doCalculatePolicyCost() {
	try {
	    premiumCostCalculatorFacade.calculatePremiumCost(policy);
	} catch (ValidationException e) {
	    FacesContext
		    .getCurrentInstance()
		    .addMessage(null,
			    new FacesMessage(FacesMessage.SEVERITY_WARN,
				    gpovts.getString(e.getMessageCode().getMessageBundleCode()),
				    gpovts.getString(e.getDescriptionCode().getMessageBundleCode())));
	}
    }

    public void onIdNumberChanged(InsuredDriver insuredDriver) {
	try {
	    policyRequestFacade.clearInsuredDriverFetchedInfo(policy, insuredDriver);
	    policyRequestFacade.fetchInsuredDriver(policy, insuredDriver);
	} catch (ValidationException e) {
	    FacesContext
		    .getCurrentInstance()
		    .addMessage(null,
			    new FacesMessage(FacesMessage.SEVERITY_WARN,
				    gpovts.getString(e.getMessageCode().getMessageBundleCode()),
				    gpovts.getString(e.getDescriptionCode().getMessageBundleCode())));
	}
	try {
	    premiumCostCalculatorFacade.calculatePremiumCost(policy);
	} catch (ValidationException e) {
	    FacesContext
		    .getCurrentInstance()
		    .addMessage(null,
			    new FacesMessage(FacesMessage.SEVERITY_WARN,
				    gpovts.getString(e.getMessageCode().getMessageBundleCode()),
				    gpovts.getString(e.getDescriptionCode().getMessageBundleCode())));
	}
    }

    public void onVinCodeChanged(InsuredVehicle insuredVehicle) {
	try {
	    policyRequestFacade.clearInsuredVehicleFetchedInfo(policy, insuredVehicle);
	    policyRequestFacade.fetchInsuredVehicle(policy, insuredVehicle);
	    premiumCostCalculatorFacade.calculatePremiumCost(policy);
	} catch (ValidationException e) {
	    FacesContext
		    .getCurrentInstance()
		    .addMessage(null,
			    new FacesMessage(FacesMessage.SEVERITY_WARN,
				    gpovts.getString(e.getMessageCode().getMessageBundleCode()),
				    gpovts.getString(e.getDescriptionCode().getMessageBundleCode())));
	}
    }

    public void onVehicleRegionChanged(InsuredVehicle insuredVehicle) {
	try {
	    policyRequestFacade.evaluateMajorCity(insuredVehicle);
	    premiumCostCalculatorFacade.calculatePremiumCost(policy);
	} catch (ValidationException e) {
	    FacesContext
		    .getCurrentInstance()
		    .addMessage(null,
			    new FacesMessage(FacesMessage.SEVERITY_WARN,
				    gpovts.getString(e.getMessageCode().getMessageBundleCode()),
				    gpovts.getString(e.getDescriptionCode().getMessageBundleCode())));
	}
    }

    // GENERATED

    public void setGlb(ResourceBundle glb) {
	this.glb = glb;
    }

    public void setPolicyRequestFacade(PolicyRequestFacade policyRequestFacade) {
	this.policyRequestFacade = policyRequestFacade;
    }

    public void setPremiumCostCalculatorFacade(PremiumCostCalculatorFacade premiumCostCalculatorFacade) {
	this.premiumCostCalculatorFacade = premiumCostCalculatorFacade;
    }

    public void setGpovts(ResourceBundle gpovts) {
	this.gpovts = gpovts;
    }

    public PolicyRequest getPolicy() {
	return policy;
    }
}
