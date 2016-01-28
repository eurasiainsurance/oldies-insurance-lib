package kz.theeurasia.policy2.osgpovts.domain;

import java.util.UUID;

import org.primefaces.model.UploadedFile;

import kz.theeurasia.services.domain.global.CountryRegion;
import kz.theeurasia.services.domain.osgpovts.VehicleAgeClass;
import kz.theeurasia.services.domain.osgpovts.VehicleClass;

public class Vehicle {
    private final UUID id;

    private CountryRegion region;
    private boolean isMajorCity;
    private VehicleClass vehicleClass;
    private VehicleAgeClass ageClass;
    private boolean majorCityTrueForced;

    private UploadedFile vehicleCertificateScanCopy;

    public Vehicle() {
	id = UUID.randomUUID();
    }

    public UUID getId() {
	return id;
    }

    public CountryRegion getRegion() {
	return region;
    }

    public void setRegion(CountryRegion region) {
	this.region = region;
    }

    public boolean isMajorCity() {
	return isMajorCity;
    }

    public void setMajorCity(boolean isMajorCity) {
	this.isMajorCity = isMajorCity;
    }

    public VehicleClass getVehicleClass() {
	return vehicleClass;
    }

    public void setVehicleClass(VehicleClass vehicleClass) {
	this.vehicleClass = vehicleClass;
    }

    public VehicleAgeClass getAgeClass() {
	return ageClass;
    }

    public void setAgeClass(VehicleAgeClass ageClass) {
	this.ageClass = ageClass;
    }

    public boolean isMajorCityTrueForced() {
	return majorCityTrueForced;
    }

    public void setMajorCityTrueForced(boolean majorCityTrueForced) {
	this.majorCityTrueForced = majorCityTrueForced;
    }

    public UploadedFile getVehicleCertificateScanCopy() {
	return vehicleCertificateScanCopy;
    }

    public void setVehicleCertificateScanCopy(UploadedFile vehicleCertificateScanCopy) {
	this.vehicleCertificateScanCopy = vehicleCertificateScanCopy;
    }

    @Override
    public int hashCode() {
	return this.getClass().hashCode() * id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	return obj != null && obj instanceof Vehicle && getId().equals(((Vehicle) obj).getId());
    }

}
