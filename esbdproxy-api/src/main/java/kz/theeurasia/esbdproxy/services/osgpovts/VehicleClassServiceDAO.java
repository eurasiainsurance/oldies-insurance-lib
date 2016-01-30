package kz.theeurasia.esbdproxy.services.osgpovts;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.services.AbstractServiceDAO;

public interface VehicleClassServiceDAO extends AbstractServiceDAO<VehicleClassDict, Long> {
    List<VehicleClassDict> getAll();
}
