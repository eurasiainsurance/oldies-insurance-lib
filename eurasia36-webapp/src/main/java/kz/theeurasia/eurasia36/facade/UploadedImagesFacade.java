package kz.theeurasia.eurasia36.facade;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import kz.theeurasia.eurasia36.services.UploadedImageService;
import kz.theeurasia.policy.domain.InsuredDriverData;
import kz.theeurasia.policy.domain.InsuredVehicleData;
import kz.theeurasia.policy.domain.PolicyRequestData;
import kz.theeurasia.policy.domain.UploadedImage;

@Named
@ViewScoped
public class UploadedImagesFacade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
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

    public void pickupHandicapedCertificateImage(PolicyRequestData policy, InsuredDriverData driver) {
	driver.getHandicapedCertificateData().getScanFiles().addAll(uploadedImageService.pickUpLast());
    }

    public void removeHandicapedCertificateImage(PolicyRequestData policy, InsuredDriverData driver,
	    UploadedImage image) {
	driver.getHandicapedCertificateData().getScanFiles().remove(image);
    }

    public void pickupGPWParticipantCertificateImage(PolicyRequestData policy, InsuredDriverData driver) {
	driver.getGpwParticipantCertificateData().getScanFiles().addAll(uploadedImageService.pickUpLast());

    }

    public void removeGPWParticipantCertificateImage(PolicyRequestData policy, InsuredDriverData driver,
	    UploadedImage image) {
	driver.getGpwParticipantCertificateData().getScanFiles().remove(image);
    }

    public void pickupPensionerCertificateImage(PolicyRequestData policy, InsuredDriverData driver) {
	driver.getPensionerCertificateData().getScanFiles().addAll(uploadedImageService.pickUpLast());

    }

    public void removePensionerCertificateImage(PolicyRequestData policy, InsuredDriverData driver,
	    UploadedImage image) {
	driver.getPensionerCertificateData().getScanFiles().remove(image);

    }

    public void pickupPrivilegerCertificateImage(PolicyRequestData policy, InsuredDriverData driver) {
	driver.getPrivilegerCertificateData().getScanFiles().addAll(uploadedImageService.pickUpLast());

    }

    public void removePrivilegerCertificateImage(PolicyRequestData policy, InsuredDriverData driver,
	    UploadedImage image) {
	driver.getPrivilegerCertificateData().getScanFiles().remove(image);

    }

    public void pickupVehicleCertificateImage(PolicyRequestData policy, InsuredVehicleData vehicle) {
	vehicle.getVehicleCertificateData().getScanFiles().addAll(uploadedImageService.pickUpLast());
    }

    public void removeVehicleCertificateImage(PolicyRequestData policy, InsuredVehicleData vehicle,
	    UploadedImage image) {
	vehicle.getVehicleCertificateData().getScanFiles().remove(image);
    }

}
