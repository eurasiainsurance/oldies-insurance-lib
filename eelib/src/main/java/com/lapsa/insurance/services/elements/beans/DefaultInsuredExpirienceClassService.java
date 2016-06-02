package com.lapsa.insurance.services.elements.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.InsuredExpirienceClass;
import com.lapsa.insurance.services.elements.InsuredExpirienceClassService;

@Named("insuredExpirienceClassService")
@ApplicationScoped
public class DefaultInsuredExpirienceClassService extends GenericEnumService<InsuredExpirienceClass> implements InsuredExpirienceClassService {

    public List<InsuredExpirienceClass> getAllItems() {
	return Arrays.asList(InsuredExpirienceClass.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return InsuredExpirienceClass.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return InsuredExpirienceClass.BUNDLE_VAR;
    }
}
