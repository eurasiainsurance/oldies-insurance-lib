package com.lapsa.insurance.services.crm.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.crm.ClosingResult;
import com.lapsa.insurance.services.crm.ClosingResultService;
import com.lapsa.insurance.services.elements.beans.GenericEnumService;

@Named("closingResultService")
@ApplicationScoped
public class DefaultClosingResultService extends GenericEnumService<ClosingResult> implements ClosingResultService {

    @Override
    public List<ClosingResult> getAllItems() {
	return Arrays.asList(ClosingResult.values());
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
