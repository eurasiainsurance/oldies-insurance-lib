package com.lapsa.insurance.esbd.services.osgpovts;

import java.util.List;

import com.lapsa.insurance.esbd.services.GeneralServiceDAO;
import com.lapsa.insurance.esbd.services.InvalidInputParameter;

import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleManufacturerEntity;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleModelEntity;

public interface VehicleModelServiceDAO extends GeneralServiceDAO<VehicleModelEntity, Long> {
    List<VehicleModelEntity> getByName(String name) throws InvalidInputParameter;

    List<VehicleModelEntity> getByManufacturer(VehicleManufacturerEntity manufacturer) throws InvalidInputParameter;
}
