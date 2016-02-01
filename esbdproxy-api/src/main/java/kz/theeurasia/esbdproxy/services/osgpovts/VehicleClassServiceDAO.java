package kz.theeurasia.esbdproxy.services.osgpovts;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleClassDict;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;

public interface VehicleClassServiceDAO extends GeneralServiceDAO<VehicleClassDict, Long> {
    List<VehicleClassDict> getAll();
}
