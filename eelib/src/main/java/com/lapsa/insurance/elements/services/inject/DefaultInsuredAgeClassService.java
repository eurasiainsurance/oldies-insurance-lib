package com.lapsa.insurance.elements.services.inject;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.InsuredAgeClass;
import com.lapsa.insurance.elements.services.InsuredAgeClassService;

@Named("insuredAgeClassService")
@ApplicationScoped
public class DefaultInsuredAgeClassService extends EnumService<InsuredAgeClass> implements InsuredAgeClassService {

    @Override
    public List<InsuredAgeClass> getAllItems() {
	return CollectionUtils.toList(InsuredAgeClass.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return InsuredAgeClass.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleName() {
	return InsuredAgeClass.BUNDLE_VAR;
    }
}
