package com.lapsa.insurance.elements.services.inject;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.InsuranceClassType;
import com.lapsa.insurance.elements.services.InsuranceClassTypeService;

@Named("insuranceClassTypeService")
@ApplicationScoped
public class DefaultInsuranceClassTypeService extends EnumService<InsuranceClassType>
	implements InsuranceClassTypeService {

    @Override
    public List<InsuranceClassType> getAllItems() {
	return CollectionUtils.toList(InsuranceClassType.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return InsuranceClassType.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleName() {
	return InsuranceClassType.BUNDLE_VAR;
    }
}
