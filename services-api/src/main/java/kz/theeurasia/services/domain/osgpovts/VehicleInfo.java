package kz.theeurasia.services.domain.osgpovts;

import kz.theeurasia.services.domain.global.CountryRegion;
import kz.theeurasia.services.domain.osgpovts.VehicleAgeClass;
import kz.theeurasia.services.domain.osgpovts.VehicleClass;

/**
 * Класс для представления сведений о транспортном средстве для расчета премии
 * ОС ГПО ВТС
 * 
 * @author vadim.isaev
 *
 */
public class VehicleInfo {
    private CountryRegion vehicleRegion;
    private boolean isMajorCity;
    private VehicleClass vehicleType;
    private VehicleAgeClass vehicleAgeType;

    public VehicleInfo(CountryRegion vehicleRegion, boolean isMajorCity, VehicleClass vehicleType,
	    VehicleAgeClass vehicleAgeType) {
	this.vehicleRegion = vehicleRegion;
	this.isMajorCity = isMajorCity;
	this.vehicleType = vehicleType;
	this.vehicleAgeType = vehicleAgeType;
    }

    public CountryRegion getVehicleRegion() {
	return vehicleRegion;
    }

    public void setVehicleRegion(CountryRegion vehicleRegion) {
	this.vehicleRegion = vehicleRegion;
    }

    public boolean isMajorCity() {
	return isMajorCity;
    }

    public void setMajorCity(boolean isMajorCity) {
	this.isMajorCity = isMajorCity;
    }

    public VehicleClass getVehicleType() {
	return vehicleType;
    }

    public void setVehicleType(VehicleClass vehicleType) {
	this.vehicleType = vehicleType;
    }

    public VehicleAgeClass getVehicleAgeType() {
	return vehicleAgeType;
    }

    public void setVehicleAgeType(VehicleAgeClass vehicleAgeType) {
	this.vehicleAgeType = vehicleAgeType;
    }

}
