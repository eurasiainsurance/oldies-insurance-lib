package kz.theeurasia.policy.view;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryRegionDict;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredAgeClassEnum;
import kz.theeurasia.esbdproxy.domain.enums.osgpovts.InsuredExpirienceClassEnum;
import kz.theeurasia.policy.domain.InsuredDriverData;
import kz.theeurasia.policy.domain.InsuredVehicleData;
import kz.theeurasia.policy.domain.PolicyRequestData;
import kz.theeurasia.policy.domain.UploadedImage;
import kz.theeurasia.policy.facade.DriverFacade;
import kz.theeurasia.policy.facade.PolicyFacade;
import kz.theeurasia.policy.facade.UploadedImagesFacade;
import kz.theeurasia.policy.facade.VehicleFacade;

@ManagedBean(name = "osgpovtsView")
@ViewScoped
public class OSGPOVTSView implements Serializable {

    private static final long serialVersionUID = 6605204552704504011L;

    @ManagedProperty("#{glb}")
    private ResourceBundle glb;

    @ManagedProperty("#{gpovts}")
    private ResourceBundle gpovts;

    @ManagedProperty("#{policyFacade}")
    private PolicyFacade policyFacade;

    @ManagedProperty("#{driverFacade}")
    private DriverFacade driverFacade;

    @ManagedProperty("#{vehicleFacade}")
    private VehicleFacade vehicleFacade;

    @ManagedProperty("#{uploadedImagesFacade}")
    private UploadedImagesFacade uploadedImagesFacade;

    private PolicyRequestData policy;

    @PostConstruct
    public void init() {
	try {
	    // this.policy = policyFacade.initNew();
	    // driverFacade.add(policy);
	    // vehicleFacade.add(policy);

	    this.policy = policyFacade.initNew();

	    InsuredDriverData drv1 = driverFacade.add(policy);
	    drv1.setIdNumber("570325300699");
	    driverFacade.fetchInfo(policy, drv1);
	    drv1.setExpirienceClass(InsuredExpirienceClassEnum.MORE2);
	    // InsuredDriverData drv2 = driverFacade.add(policy);
	    // drv2.setIdNumber("870622300359");
	    // driverFacade.fetchInfo(policy, drv2);

	    InsuredDriverData drv3 = driverFacade.add(policy);
	    drv3.setIdNumber("800225000319");
	    driverFacade.fetchInfo(policy, drv3);
	    drv3.setAgeClass(InsuredAgeClassEnum.OVER25);
	    drv3.setExpirienceClass(InsuredExpirienceClassEnum.MORE2);

	    // InsuredDriverData drv4 = driverFacade.add(policy);
	    // drv4.setIdNumber("860401402685");
	    // driverFacade.fetchInfo(policy, drv4);

	    InsuredVehicleData vhc1 = vehicleFacade.add(policy);
	    vhc1.setVinCode("JN1TANS51U0303376");
	    vehicleFacade.fetchInfo(policy, vhc1);
	    vhc1.getCertificateData().setRegion(CountryRegionDict.GALM);
	    vehicleFacade.evaluateMajorCity(vhc1);
	    policyFacade.calculatePremiumCost(policy);

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
	    driverFacade.add(policy);
	} catch (ValidationException e) {
	    FacesContext
		    .getCurrentInstance()
		    .addMessage(null,
			    new FacesMessage(FacesMessage.SEVERITY_WARN,
				    gpovts.getString(e.getMessageCode().getMessageBundleCode()),
				    gpovts.getString(e.getDescriptionCode().getMessageBundleCode())));
	}
	policyFacade.calculatePremiumCost(policy);
    }

    public void removeInsuredDriver(InsuredDriverData driver) {
	try {
	    driverFacade.remove(policy, driver);
	} catch (ValidationException e) {
	    FacesContext
		    .getCurrentInstance()
		    .addMessage(null,
			    new FacesMessage(FacesMessage.SEVERITY_WARN,
				    gpovts.getString(e.getMessageCode().getMessageBundleCode()),
				    gpovts.getString(e.getDescriptionCode().getMessageBundleCode())));
	}
	policyFacade.calculatePremiumCost(policy);
    }

    public void addInsuredVehicle() {
	try {
	    vehicleFacade.add(policy);
	} catch (ValidationException e) {
	    FacesContext
		    .getCurrentInstance()
		    .addMessage(null,
			    new FacesMessage(FacesMessage.SEVERITY_WARN,
				    gpovts.getString(e.getMessageCode().getMessageBundleCode()),
				    gpovts.getString(e.getDescriptionCode().getMessageBundleCode())));
	}
	policyFacade.calculatePremiumCost(policy);
    }

    public void removeInsuredVehicle(InsuredVehicleData insuredVehicle) {
	try {
	    vehicleFacade.remove(policy, insuredVehicle);
	} catch (ValidationException e) {
	    FacesContext
		    .getCurrentInstance()
		    .addMessage(null,
			    new FacesMessage(FacesMessage.SEVERITY_WARN,
				    gpovts.getString(e.getMessageCode().getMessageBundleCode()),
				    gpovts.getString(e.getDescriptionCode().getMessageBundleCode())));
	}
	policyFacade.calculatePremiumCost(policy);
    }

    public void doCalculatePolicyCost() {
	policyFacade.calculatePremiumCost(policy);
    }

    public void onDriverIdNumberChanged(InsuredDriverData insuredDriver) {
	try {
	    driverFacade.fetchInfo(policy, insuredDriver);
	} catch (ValidationException e) {
	}
	policyFacade.calculatePremiumCost(policy);
    }

    public void onPolicyCostCalculationFormChanged() {
	policyFacade.calculatePremiumCost(policy);
    }

    public void onVehicleVinCodeChanged(InsuredVehicleData insuredVehicle) {
	try {
	    vehicleFacade.fetchInfo(policy, insuredVehicle);
	} catch (ValidationException e) {
	}
	policyFacade.calculatePremiumCost(policy);
    }

    public void onVehicleRegionChanged(InsuredVehicleData insuredVehicle) {
	vehicleFacade.evaluateMajorCity(insuredVehicle);
	policyFacade.calculatePremiumCost(policy);
    }

    public void onDriverIdentityCardImageUploaded(InsuredDriverData driver) {
	uploadedImagesFacade.pickupIdentityCardImage(policy, driver);
    }

    public void removeDriverIdentityCardImage(InsuredDriverData driver, UploadedImage image) {
	uploadedImagesFacade.removeIdentityCardImage(policy, driver, image);
    }

    public void onDriverLicenseImageUploaded(InsuredDriverData driver) {
	uploadedImagesFacade.pickupDriverLicenseImage(policy, driver);
    }

    public void removeDriverLicenseImage(InsuredDriverData driver, UploadedImage image) {
	uploadedImagesFacade.removeDriverLicenseImage(policy, driver, image);
    }

    public void onHandicapedCertificateImageUploaded(InsuredDriverData driver) {
	uploadedImagesFacade.pickupHandicapedCertificateImage(policy, driver);
    }

    public void removeHandicapedCertificateImage(InsuredDriverData driver, UploadedImage image) {
	uploadedImagesFacade.removeHandicapedCertificateImage(policy, driver, image);
    }

    public void onGPWParticipantCertificateImageUploaded(InsuredDriverData driver) {
	uploadedImagesFacade.pickupGPWParticipantCertificateImage(policy, driver);
    }

    public void removeGPWParticipantCertificateImage(InsuredDriverData driver, UploadedImage image) {
	uploadedImagesFacade.removeGPWParticipantCertificateImage(policy, driver, image);
    }

    public void onPensionerCertificateImageUploaded(InsuredDriverData driver) {
	uploadedImagesFacade.pickupPensionerCertificateImage(policy, driver);
    }

    public void removePensionerCertificateImage(InsuredDriverData driver, UploadedImage image) {
	uploadedImagesFacade.removePensionerCertificateImage(policy, driver, image);
    }

    public void onPrivilegerCertificateImageUploaded(InsuredDriverData driver) {
	uploadedImagesFacade.pickupPrivilegerCertificateImage(policy, driver);
    }

    public void removePrivilegerCertificateImage(InsuredDriverData driver, UploadedImage image) {
	uploadedImagesFacade.removePrivilegerCertificateImage(policy, driver, image);
    }

    // GENERATED

    public void setGlb(ResourceBundle glb) {
	this.glb = glb;
    }

    public void setPolicyFacade(PolicyFacade policyFacade) {
	this.policyFacade = policyFacade;
    }

    public void setDriverFacade(DriverFacade driverFacade) {
	this.driverFacade = driverFacade;
    }

    public void setVehicleFacade(VehicleFacade vehicleFacade) {
	this.vehicleFacade = vehicleFacade;
    }

    public void setGpovts(ResourceBundle gpovts) {
	this.gpovts = gpovts;
    }

    public PolicyRequestData getPolicy() {
	return policy;
    }

    public void setUploadedImagesFacade(UploadedImagesFacade uploadedImagesFacade) {
	this.uploadedImagesFacade = uploadedImagesFacade;
    }

}
