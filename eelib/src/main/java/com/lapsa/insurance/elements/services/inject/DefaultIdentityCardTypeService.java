package com.lapsa.insurance.elements.services.inject;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.IdentityCardType;
import com.lapsa.insurance.elements.services.IdentityCardTypeService;

@Named("identityCardTypeService")
@ApplicationScoped
public class DefaultIdentityCardTypeService extends EnumService<IdentityCardType> implements IdentityCardTypeService {

    public List<IdentityCardType> getAllItems() {
	return CollectionUtils.toList(IdentityCardType.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return IdentityCardType.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleName() {
	return IdentityCardType.BUNDLE_VAR;
    }
}
