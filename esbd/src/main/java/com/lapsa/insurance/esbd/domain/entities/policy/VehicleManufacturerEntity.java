package com.lapsa.insurance.esbd.domain.entities.policy;

public class VehicleManufacturerEntity {
    // ID s:int Идентификатор
    private long id;

    // NAME s:string Наименование марки
    private String name;

    // IS_FOREIGN_BOOL s:int Признак иностранной марки
    private boolean foreign;

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

    public boolean isForeign() {
	return foreign;
    }

    public void setForeign(boolean foreign) {
	this.foreign = foreign;
    }

}
