package kz.theeurasia.esbdproxy.services.osgpovts;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleManufacturerEntity;
import kz.theeurasia.esbdproxy.services.AbstractServiceDAO;

public interface VehicleManufacturerServiceDAO extends AbstractServiceDAO<VehicleManufacturerEntity, Long> {
    List<VehicleManufacturerEntity> getByName(String name);
}
