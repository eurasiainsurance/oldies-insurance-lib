package kz.theeurasia.esbdproxy.services.osgpovts;

import java.util.List;

import kz.theeurasia.esbdproxy.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.services.EntityServiceDAO;

public interface VehicleClassServiceDAO extends EntityServiceDAO<VehicleClassDict, Long> {
    List<VehicleClassDict> getAll();
}
