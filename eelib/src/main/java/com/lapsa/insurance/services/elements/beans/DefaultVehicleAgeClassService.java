package com.lapsa.insurance.services.elements.beans;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.VehicleAgeClass;
import com.lapsa.insurance.services.elements.VehicleAgeClassService;

@Named("vehicleAgeClassService")
@ApplicationScoped
public class DefaultVehicleAgeClassService extends GenericEnumService<VehicleAgeClass> implements VehicleAgeClassService {

    public List<VehicleAgeClass> getAllItems() {
	return CollectionUtils.toList(VehicleAgeClass.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return VehicleAgeClass.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return VehicleAgeClass.BUNDLE_VAR;
    }
}
