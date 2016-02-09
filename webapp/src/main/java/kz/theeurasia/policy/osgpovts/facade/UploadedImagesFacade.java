package kz.theeurasia.policy.osgpovts.facade;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import kz.theeurasia.policy.general.domain.UploadedImage;
import kz.theeurasia.policy.general.service.UploadedImageService;
import kz.theeurasia.policy.osgpovts.domain.InsuredDriverData;
import kz.theeurasia.policy.osgpovts.domain.PolicyRequestData;

@ManagedBean
@ViewScoped
public class UploadedImagesFacade {

    @ManagedProperty("#{uploadedImageService}")
    private UploadedImageService uploadedImageService;

    public void pickupIdentityCardImage(PolicyRequestData policy, InsuredDriverData driver) {
	driver.getIdentityCardData().getScanFiles().addAll(uploadedImageService.pickUpLast());
    }

    public void removeIdentityCardImage(PolicyRequestData policy, InsuredDriverData driver, UploadedImage image) {
	driver.getIdentityCardData().getScanFiles().remove(image);
    }

    public void pickupDriverLicenseImage(PolicyRequestData policy, InsuredDriverData driver) {
	driver.getDriverLicenseData().getScanFiles().addAll(uploadedImageService.pickUpLast());
    }

    public void removeDriverLicenseImage(PolicyRequestData policy, InsuredDriverData driver, UploadedImage image) {
	driver.getDriverLicenseData().getScanFiles().remove(image);
    }

    // GENERATED

    public void setUploadedImageService(UploadedImageService uploadedImageService) {
	this.uploadedImageService = uploadedImageService;
    }

}
