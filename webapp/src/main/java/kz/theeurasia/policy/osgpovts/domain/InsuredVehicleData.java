package kz.theeurasia.policy.osgpovts.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.primefaces.model.UploadedFile;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryRegionDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleAgeClassDict;
import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleEntity;
import kz.theeurasia.policy.validator.Required;
import kz.theeurasia.policy.validator.VINCode;

public class InsuredVehicleData {
    private final UUID id = UUID.randomUUID();

    private VehicleClassDict vehicleClass = VehicleClassDict.UNSPECIFIED;
    private VehicleAgeClassDict vehicleAgeClass = VehicleAgeClassDict.UNSPECIFIED;

    @Required
    @VINCode
    private String vinCode = "";

    private String vehicleModel = "";

    private String vehicleManufacturer = "";

    private VehicleCertificateData certificateData = new VehicleCertificateData();
    private List<UploadedFile> certificateDocuments = new ArrayList<>();

    private CountryRegionDict region = CountryRegionDict.UNSPECIFIED;
    private boolean majorCity;
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

    public void setVinCode(String vinCode) {
	this.vinCode = vinCode;
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

    public List<UploadedFile> getCertificateDocuments() {
	return certificateDocuments;
    }

    public void setCertificateDocuments(List<UploadedFile> certificateDocuments) {
	this.certificateDocuments = certificateDocuments;
    }

    public CountryRegionDict getRegion() {
	return region;
    }

    public void setRegion(CountryRegionDict region) {
	this.region = region;
    }

    public boolean isMajorCity() {
	return majorCity;
    }

    public void setMajorCity(boolean majorCity) {
	this.majorCity = majorCity;
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

}
