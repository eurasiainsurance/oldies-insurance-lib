package com.lapsa.insurance.services.elements.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.crm.RequestStatus;
import com.lapsa.insurance.services.elements.RequestStatusService;

@Named("requestStatusService")
@ApplicationScoped
public class DefaultRequestStatusService extends GenericEnumService<RequestStatus> implements RequestStatusService {

    @Override
    public List<RequestStatus> getAllItems() {
	return Arrays.asList(RequestStatus.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return RequestStatus.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return RequestStatus.BUNDLE_VAR;
    }
}
