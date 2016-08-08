package com.lapsa.insurance.esbd.services.policy;

import com.lapsa.insurance.esbd.domain.entities.policy.VehicleEntity;
import com.lapsa.insurance.esbd.services.GeneralServiceDAO;
import com.lapsa.insurance.esbd.services.InvalidInputParameter;
import com.lapsa.insurance.esbd.services.NotFound;

public interface VehicleServiceDAO extends GeneralServiceDAO<VehicleEntity, Long> {
    VehicleEntity getByVINCode(String vinCode) throws NotFound, InvalidInputParameter;
}
