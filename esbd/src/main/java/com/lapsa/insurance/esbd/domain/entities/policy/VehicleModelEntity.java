package com.lapsa.insurance.esbd.domain.entities.policy;

public class VehicleModelEntity {
    // ID s:int Идентификатор модели
    private long id;

    // NAME s:string Наименование модели
    private String name;

    // VOITURE_MARK_ID s:int Идентификатор марки ТС
    private VehicleManufacturerEntity manufacturer;

    @Override
    public int hashCode() {
	return this.getClass().hashCode() * new Long(id).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	return obj != null && this.getClass().isInstance(obj) && getId() == this.getClass().cast(obj).getId();
    }

    // GENERATED

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public VehicleManufacturerEntity getManufacturer() {
	return manufacturer;
    }

    public void setManufacturer(VehicleManufacturerEntity manufacturer) {
	this.manufacturer = manufacturer;
    }
}
