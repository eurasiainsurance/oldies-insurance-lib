package com.lapsa.insurance.services.elements;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.insurance.elements.SteeringWheelLocation;

public interface SteeringWheelLocationService extends NamingListingService<SteeringWheelLocation> {

    @Override
    default SteeringWheelLocation[] getAll() {
	return SteeringWheelLocation.values();
    }

    @Override
    default SteeringWheelLocation[] getSelectable() {
	return SteeringWheelLocation.selectableValues();
    }

    @Override
    default SteeringWheelLocation[] getNonSelectable() {
	return SteeringWheelLocation.nonSelectableValues();
    }
}
