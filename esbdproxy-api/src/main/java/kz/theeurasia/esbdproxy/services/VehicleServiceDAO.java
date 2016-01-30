package kz.theeurasia.esbdproxy.services;

import kz.theeurasia.esbdproxy.domain.entities.VehicleEntity;

public interface VehicleServiceDAO extends AbstractServiceDAO<VehicleEntity, Long> {
    VehicleEntity getByVINCode(String vinCode) throws NotFound;
}
