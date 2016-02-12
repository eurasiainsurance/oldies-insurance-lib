package kz.theeurasia.policy.domain;

import java.util.Locale;
import java.util.UUID;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleAgeClassDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleEntity;
import kz.theeurasia.policy.validator.NotEmptyString;
import kz.theeurasia.policy.validator.NotNullValue;
import kz.theeurasia.policy.validator.ValidVINCode;
import kz.theeurasia.policy.validator.ValidVehicleAgeClass;
import kz.theeurasia.policy.validator.ValidVehicleClass;

public class InsuredVehicleData {
    private final UUID id = UUID.randomUUID();

    @NotNullValue
    @ValidVINCode
    private String vinCode;

    @NotNullValue
    @ValidVehicleClass
    private VehicleClassDict vehicleClass = VehicleClassDict.UNSPECIFIED;

    @NotNullValue
    @ValidVehicleAgeClass
    private VehicleAgeClassDict vehicleAgeClass = VehicleAgeClassDict.UNSPECIFIED;

    @NotNullValue
    @NotEmptyString
    private String vehicleModel;

    @NotNullValue
    @NotEmptyString
    private String vehicleManufacturer;

    @NotNullValue
    @NotEmptyString
    private String vehicleColor;

    private VehicleCertificateData certificateData = new VehicleCertificateData();

    private boolean forcedMajorCity;

    // esbd entities
    private VehicleEntity fetchedEntity;

    @Override
    public int hashCode() {
	return this.getClass().hashCode() * id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	return obj != null && this.getClass().isInstance(obj) && getId().equals((this.getClass().cast(obj)).getId());
    }

    public String getDisplayName() {
	return (((vehicleManufacturer == null || vehicleManufacturer.isEmpty()) ? ""
		: (vehicleManufacturer + " ")) +
		((vehicleModel == null || vehicleModel.isEmpty()) ? ""
			: (vehicleModel + " "))).trim();
    }

    public boolean isFetched() {
	return fetchedEntity != null;
    }

    public String getSafeId() {
	return id.toString().replaceAll("-", "_");
    }

    public void setVinCode(String vinCode) {
	this.vinCode = vinCode;
	if (this.vinCode != null)
	    this.vinCode = this.vinCode.toUpperCase(Locale.ENGLISH);
    }

    // GENERATED

    public UUID getId() {
	return id;
    }

    public VehicleClassDict getVehicleClass() {
	return vehicleClass;
    }

    public void setVehicleClass(VehicleClassDict vehicleClass) {
	this.vehicleClass = vehicleClass;
    }

    public VehicleAgeClassDict getVehicleAgeClass() {
	return vehicleAgeClass;
    }

    public void setVehicleAgeClass(VehicleAgeClassDict vehicleAgeClass) {
	this.vehicleAgeClass = vehicleAgeClass;
    }

    public String getVinCode() {
	return vinCode;
    }

    public String getVehicleModel() {
	return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
	this.vehicleModel = vehicleModel;
    }

    public String getVehicleManufacturer() {
	return vehicleManufacturer;
    }

    public void setVehicleManufacturer(String vehicleManufacturer) {
	this.vehicleManufacturer = vehicleManufacturer;
    }

    public VehicleCertificateData getCertificateData() {
	return certificateData;
    }

    public void setCertificateData(VehicleCertificateData certificateData) {
	this.certificateData = certificateData;
    }

    public boolean isForcedMajorCity() {
	return forcedMajorCity;
    }

    public void setForcedMajorCity(boolean forcedMajorCity) {
	this.forcedMajorCity = forcedMajorCity;
    }

    public VehicleEntity getFetchedEntity() {
	return fetchedEntity;
    }

    public void setFetchedEntity(VehicleEntity fetchedEntity) {
	this.fetchedEntity = fetchedEntity;
    }

    public String getVehicleColor() {
	return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
	this.vehicleColor = vehicleColor;
    }
}
