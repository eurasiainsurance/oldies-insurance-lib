package com.lapsa.insurance.elements.services.beans;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.crm.RequestStatus;
import com.lapsa.insurance.elements.services.RequestStatusService;

@Named("requestStatusService")
@ApplicationScoped
public class DefaultRequestStatusService extends EnumService<RequestStatus> implements RequestStatusService {

    @Override
    public List<RequestStatus> getAllItems() {
	return CollectionUtils.toList(RequestStatus.values());
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
