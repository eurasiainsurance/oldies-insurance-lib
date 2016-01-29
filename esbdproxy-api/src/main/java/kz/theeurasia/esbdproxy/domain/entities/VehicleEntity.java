package kz.theeurasia.esbdproxy.domain.entities;

import java.util.Calendar;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleModelEntity;
import kz.theeurasia.esbdproxy.domain.infos.osgpovts.SteeringWheelLocationInfo;

public class VehicleEntity {
    // TF_ID s:int Идентификатор ТС
    private long id;

    // TF_TYPE_ID s:int Тип ТС (справочник TF_TYPES)
    private VehicleClassDict vehicleClass;

    // VIN s:string VIN код (номер кузова) (обязательно)
    private String vinCode;

    // MODEL_ID s:int Марка\Модель (справочник VOITURE_MODELS) (обязательно)
    private VehicleModelEntity vehicleModel;

    // RIGHT_HAND_DRIVE_BOOL s:int Признак расположения руля (0 - слева; 1 -
    // справа)
    private SteeringWheelLocationInfo steeringWheelLocation;

    // ENGINE_VOLUME s:int Объем двигателя (куб.см.)
    private int engineVolume;

    // ENGINE_NUMBER s:string Номер двигателя
    private String enineNumber;

    // ENGINE_POWER s:int Мощность двигателя (квт.)
    private int enginePower;

    // COLOR s:string Цвет ТС
    private String color;

    // BORN s:string Год выпуска (обязательно)
    // BORN_MONTH s:int Месяц выпуска ТС
    private Calendar realeaseDate;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public VehicleClassDict getVehicleClass() {
	return vehicleClass;
    }

    public void setVehicleClass(VehicleClassDict vehicleClass) {
	this.vehicleClass = vehicleClass;
    }

    public String getVinCode() {
	return vinCode;
    }

    public void setVinCode(String vinCode) {
	this.vinCode = vinCode;
    }

    public VehicleModelEntity getVehicleModel() {
	return vehicleModel;
    }

    public void setVehicleModel(VehicleModelEntity vehicleModel) {
	this.vehicleModel = vehicleModel;
    }

    public SteeringWheelLocationInfo getSteeringWheelLocation() {
	return steeringWheelLocation;
    }

    public void setSteeringWheelLocation(SteeringWheelLocationInfo steeringWheelLocation) {
	this.steeringWheelLocation = steeringWheelLocation;
    }

    public int getEngineVolume() {
	return engineVolume;
    }

    public void setEngineVolume(int engineVolume) {
	this.engineVolume = engineVolume;
    }

    public String getEnineNumber() {
	return enineNumber;
    }

    public void setEnineNumber(String enineNumber) {
	this.enineNumber = enineNumber;
    }

    public int getEnginePower() {
	return enginePower;
    }

    public void setEnginePower(int enginePower) {
	this.enginePower = enginePower;
    }

    public String getColor() {
	return color;
    }

    public void setColor(String color) {
	this.color = color;
    }

    public Calendar getRealeaseDate() {
	return realeaseDate;
    }

    public void setRealeaseDate(Calendar realeaseDate) {
	this.realeaseDate = realeaseDate;
    }
}
