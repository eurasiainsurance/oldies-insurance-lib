package kz.theeurasia.esbdproxy.services;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleManufacturerEntity;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleModelEntity;

public interface VehicleModelServiceDAO extends AbstractServiceDAO<VehicleModelEntity, Long> {
    List<VehicleModelEntity> getByName(String name);
    List<VehicleModelEntity> getByManufacturer(VehicleManufacturerEntity manufacturer);
}
