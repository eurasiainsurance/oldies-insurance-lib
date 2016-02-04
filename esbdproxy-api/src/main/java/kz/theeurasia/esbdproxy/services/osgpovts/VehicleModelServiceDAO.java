package kz.theeurasia.esbdproxy.services.osgpovts;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleManufacturerEntity;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleModelEntity;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;

public interface VehicleModelServiceDAO extends GeneralServiceDAO<VehicleModelEntity, Long> {
    List<VehicleModelEntity> getByName(String name) throws InvalidInputParameter;

    List<VehicleModelEntity> getByManufacturer(VehicleManufacturerEntity manufacturer) throws InvalidInputParameter;
}
