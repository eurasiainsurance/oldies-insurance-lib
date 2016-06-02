package com.lapsa.insurance.elements.services.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.VehicleClass;
import com.lapsa.insurance.elements.services.VehicleClassService;

@Named("vehicleClassService")
@ApplicationScoped
public class DefaultVehicleClassService extends GenericEnumService<VehicleClass> implements VehicleClassService {

    @Override
    public List<VehicleClass> getAllItems() {
	return CollectionUtils.toList(VehicleClass.values());
    }

    @Override
    public List<VehicleClass> getSelectableItems() {
	List<VehicleClass> res = new ArrayList<>();
	for (VehicleClass c : VehicleClass.values()) {
	    if (c.isApplicableForOSGPOVTS())
		res.add(c);
	}
	return res;
    }

    @Override
    protected String getMessageBundleBase() {
	return VehicleClass.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return VehicleClass.BUNDLE_VAR;
    }
}
