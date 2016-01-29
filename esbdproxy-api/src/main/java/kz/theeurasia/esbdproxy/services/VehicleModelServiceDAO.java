package kz.theeurasia.esbdproxy.services;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleModelEntity;

public interface VehicleModelServiceDAO extends EntityServiceDAO<VehicleModelEntity, Long> {
    List<VehicleModelEntity> getAll();
}
