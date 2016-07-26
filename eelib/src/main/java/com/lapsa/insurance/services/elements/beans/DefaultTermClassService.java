package com.lapsa.insurance.services.elements.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.PolicyTermClass;
import com.lapsa.insurance.services.elements.PolicyTermClassService;

@Named("policyTermClassService")
@ApplicationScoped
public class DefaultPolicyTermClassService extends GenericEnumService<PolicyTermClass>
	implements PolicyTermClassService {

    public List<PolicyTermClass> getAllItems() {
	return Arrays.asList(PolicyTermClass.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return PolicyTermClass.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return PolicyTermClass.BUNDLE_VAR;
    }
}
