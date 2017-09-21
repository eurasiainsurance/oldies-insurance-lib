package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.VehicleAgeClass;

public interface VehicleAgeClassService extends NamingListingService<VehicleAgeClass> {

    @Override
    default VehicleAgeClass[] getAll() {
	return VehicleAgeClass.values();
    }

    @Override
    default VehicleAgeClass[] getSelectable() {
	return VehicleAgeClass.values();
    }

    @Override
    default VehicleAgeClass[] getNonSelectable() {
	return new VehicleAgeClass[0];
    }
}
