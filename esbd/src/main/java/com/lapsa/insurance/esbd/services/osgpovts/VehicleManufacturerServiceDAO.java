package com.lapsa.insurance.esbd.services.osgpovts;

import java.util.List;

import com.lapsa.insurance.esbd.services.GeneralServiceDAO;

import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleManufacturerEntity;

public interface VehicleManufacturerServiceDAO extends GeneralServiceDAO<VehicleManufacturerEntity, Long> {
    List<VehicleManufacturerEntity> getByName(String name);
}
