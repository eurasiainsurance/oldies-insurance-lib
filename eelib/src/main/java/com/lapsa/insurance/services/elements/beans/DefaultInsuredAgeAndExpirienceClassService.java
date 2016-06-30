package com.lapsa.insurance.services.elements.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.InsuredAgeAndExpirienceClass;
import com.lapsa.insurance.services.elements.InsuredAgeAndExpirienceClassService;

@Named("insuredAgeAndExpirienceClassService")
@ApplicationScoped
public class DefaultInsuredAgeAndExpirienceClassService extends GenericEnumService<InsuredAgeAndExpirienceClass> implements InsuredAgeAndExpirienceClassService {

    @Override
    public List<InsuredAgeAndExpirienceClass> getAllItems() {
	return Arrays.asList(InsuredAgeAndExpirienceClass.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return InsuredAgeAndExpirienceClass.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return InsuredAgeAndExpirienceClass.BUNDLE_VAR;
    }
}
