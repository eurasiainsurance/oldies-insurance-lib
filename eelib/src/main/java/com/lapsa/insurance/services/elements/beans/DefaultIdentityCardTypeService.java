package com.lapsa.insurance.services.elements.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.IdentityCardType;
import com.lapsa.insurance.services.elements.IdentityCardTypeService;

@Named("identityCardTypeService")
@ApplicationScoped
public class DefaultIdentityCardTypeService extends GenericEnumService<IdentityCardType>
	implements IdentityCardTypeService {

    public List<IdentityCardType> getAllItems() {
	return Arrays.asList(IdentityCardType.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return IdentityCardType.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return IdentityCardType.BUNDLE_VAR;
    }
}
