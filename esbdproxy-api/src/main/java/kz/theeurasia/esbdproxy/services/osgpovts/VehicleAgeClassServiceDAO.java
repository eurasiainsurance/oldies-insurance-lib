package kz.theeurasia.esbdproxy.services.osgpovts;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.VehicleAgeClassDict;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;

public interface VehicleAgeClassServiceDAO extends GeneralServiceDAO<VehicleAgeClassDict, Long> {
    List<VehicleAgeClassDict> getAll();

    List<VehicleAgeClassDict> getApplicableForOSGPOVTS();
}