package com.lapsa.insurance.services.elements.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.CancelationReason;
import com.lapsa.insurance.services.elements.CancelationReasonService;

@Named("cancelationReasonService")
@ApplicationScoped
public class DefaultCancelationReasonService extends GenericEnumService<CancelationReason>
	implements CancelationReasonService {

    public List<CancelationReason> getAllItems() {
	return Arrays.asList(CancelationReason.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return CancelationReason.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return CancelationReason.BUNDLE_VAR;
    }
}
