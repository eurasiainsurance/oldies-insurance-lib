package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.VehicleClass;

public interface VehicleClassService extends NamingListingService<VehicleClass> {

    @Override
    default VehicleClass[] getAll() {
	return VehicleClass.values();
    }

    @Override
    default VehicleClass[] getSelectable() {
	return VehicleClass.selectableValues();
    }

    @Override
    default VehicleClass[] getNonSelectable() {
	return VehicleClass.nonSelectableValues();
    }

    default VehicleClass[] getValidForMotorTPL() {
	return VehicleClass.validForMotorTPLValues();
    }
}
