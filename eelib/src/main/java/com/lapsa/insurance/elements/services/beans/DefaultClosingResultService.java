package com.lapsa.insurance.elements.services.beans;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.crm.ClosingResult;
import com.lapsa.insurance.elements.services.ClosingResultService;

@Named("closingResultService")
@ApplicationScoped
public class DefaultClosingResultService extends EnumService<ClosingResult> implements ClosingResultService {

    @Override
    public List<ClosingResult> getAllItems() {
	return CollectionUtils.toList(ClosingResult.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return ClosingResult.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return ClosingResult.BUNDLE_VAR;
    }
}
