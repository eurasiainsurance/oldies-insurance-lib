package com.lapsa.insurance.services.elements.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.InsuranceClassType;
import com.lapsa.insurance.services.elements.InsuranceClassTypeService;

@Named("insuranceClassTypeService")
@ApplicationScoped
public class DefaultInsuranceClassTypeService extends GenericEnumService<InsuranceClassType>
	implements InsuranceClassTypeService {

    @Override
    public List<InsuranceClassType> getAllItems() {
	return Arrays.asList(InsuranceClassType.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return InsuranceClassType.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return InsuranceClassType.BUNDLE_VAR;
    }
}
