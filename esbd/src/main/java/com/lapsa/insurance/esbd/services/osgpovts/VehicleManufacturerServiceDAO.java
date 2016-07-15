package kz.theeurasia.esbdproxy.services.osgpovts;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleManufacturerEntity;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;

public interface VehicleManufacturerServiceDAO extends GeneralServiceDAO<VehicleManufacturerEntity, Long> {
    List<VehicleManufacturerEntity> getByName(String name);
}
