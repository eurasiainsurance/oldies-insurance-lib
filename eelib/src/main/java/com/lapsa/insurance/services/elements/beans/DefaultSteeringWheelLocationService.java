package com.lapsa.insurance.services.elements.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.SteeringWheelLocation;
import com.lapsa.insurance.services.elements.SteeringWheelLocationService;

@Named("steeringWheelLocationService")
@ApplicationScoped
public class DefaultSteeringWheelLocationService extends GenericEnumService<SteeringWheelLocation>
	implements SteeringWheelLocationService {

    public List<SteeringWheelLocation> getAllItems() {
	return Arrays.asList(SteeringWheelLocation.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return SteeringWheelLocation.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return SteeringWheelLocation.BUNDLE_VAR;
    }
}
