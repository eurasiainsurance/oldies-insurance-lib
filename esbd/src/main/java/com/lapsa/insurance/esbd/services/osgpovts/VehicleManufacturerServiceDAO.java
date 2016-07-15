package com.lapsa.insurance.esbd.services.osgpovts;

import java.util.List;

import com.lapsa.insurance.esbd.domain.entities.osgpovts.VehicleManufacturerEntity;
import com.lapsa.insurance.esbd.services.GeneralServiceDAO;

public interface VehicleManufacturerServiceDAO extends GeneralServiceDAO<VehicleManufacturerEntity, Long> {
    List<VehicleManufacturerEntity> getByName(String name);
}
