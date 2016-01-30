package kz.theeurasia.esbdproxy.services.osgpovts;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleAgeClassDict;
import kz.theeurasia.esbdproxy.services.AbstractServiceDAO;

public interface VehicleAgeClassServiceDAO extends AbstractServiceDAO<VehicleAgeClassDict, Long> {
    List<VehicleAgeClassDict> getAll();
}
