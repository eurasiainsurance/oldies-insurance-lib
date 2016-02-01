package kz.theeurasia.esbdproxy.services.osgpovts;

import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleEntity;
import kz.theeurasia.esbdproxy.services.AbstractServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

public interface VehicleServiceDAO extends AbstractServiceDAO<VehicleEntity, Long> {
    VehicleEntity getByVINCode(String vinCode) throws NotFound;
}
