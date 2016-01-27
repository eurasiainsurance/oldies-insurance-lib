package kz.theeurasia.services.services;

import kz.theeurasia.services.domain.osgpovts.InsuredInfo;
import kz.theeurasia.services.domain.osgpovts.PolicyTermClass;
import kz.theeurasia.services.domain.osgpovts.VehicleInfo;

public interface OSGPOVTSCalculator {

    // TODO https://gitrepo.theeurasia.kz/eurasia/eurasia-services/issues/10
    double calculatePremium(InsuredInfo[] insuredInfos, VehicleInfo vehicleInfo, PolicyTermClass policyTermClass);

    double calculatePremium(InsuredInfo insuredInfo, VehicleInfo[] vehicleInfos, PolicyTermClass policyTermClass);
}
