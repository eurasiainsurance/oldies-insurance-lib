package com.lapsa.insurance.services.elements.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.InsuredAgeClass;
import com.lapsa.insurance.services.elements.InsuredAgeClassService;

@Named("insuredAgeClassService")
@ApplicationScoped
public class DefaultInsuredAgeClassService extends GenericEnumService<InsuredAgeClass> implements InsuredAgeClassService {

    @Override
    public List<InsuredAgeClass> getAllItems() {
	return Arrays.asList(InsuredAgeClass.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return InsuredAgeClass.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return InsuredAgeClass.BUNDLE_VAR;
    }
}
