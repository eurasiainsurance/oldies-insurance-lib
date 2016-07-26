package com.lapsa.insurance.services.elements.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.TermClass;
import com.lapsa.insurance.services.elements.TermClassService;

@Named("policyTermClassService")
@ApplicationScoped
public class DefaultTermClassService extends GenericEnumService<TermClass>
	implements TermClassService {

    public List<TermClass> getAllItems() {
	return Arrays.asList(TermClass.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return TermClass.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return TermClass.BUNDLE_VAR;
    }
}
