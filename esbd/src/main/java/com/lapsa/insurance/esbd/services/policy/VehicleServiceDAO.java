package com.lapsa.insurance.esbd.services.osgpovts;

import com.lapsa.insurance.esbd.domain.entities.osgpovts.VehicleEntity;
import com.lapsa.insurance.esbd.services.GeneralServiceDAO;
import com.lapsa.insurance.esbd.services.InvalidInputParameter;
import com.lapsa.insurance.esbd.services.NotFound;

public interface VehicleServiceDAO extends GeneralServiceDAO<VehicleEntity, Long> {
    VehicleEntity getByVINCode(String vinCode) throws NotFound, InvalidInputParameter;
}
