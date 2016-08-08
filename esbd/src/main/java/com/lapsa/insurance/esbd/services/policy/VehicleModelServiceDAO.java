package com.lapsa.insurance.esbd.services.policy;

import java.util.List;

import com.lapsa.insurance.esbd.domain.entities.policy.VehicleManufacturerEntity;
import com.lapsa.insurance.esbd.domain.entities.policy.VehicleModelEntity;
import com.lapsa.insurance.esbd.services.GeneralServiceDAO;
import com.lapsa.insurance.esbd.services.InvalidInputParameter;

public interface VehicleModelServiceDAO extends GeneralServiceDAO<VehicleModelEntity, Long> {
    List<VehicleModelEntity> getByName(String name) throws InvalidInputParameter;

    List<VehicleModelEntity> getByManufacturer(VehicleManufacturerEntity manufacturer) throws InvalidInputParameter;
}
