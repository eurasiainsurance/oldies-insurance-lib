package kz.theeurasia.esbdproxy.services.osgpovts;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleAgeClassDict;
import kz.theeurasia.esbdproxy.services.EntityServiceDAO;

public interface VehicleAgeClassServiceDAO extends EntityServiceDAO<VehicleAgeClassDict, Long> {
    List<VehicleAgeClassDict> getAll();
}
