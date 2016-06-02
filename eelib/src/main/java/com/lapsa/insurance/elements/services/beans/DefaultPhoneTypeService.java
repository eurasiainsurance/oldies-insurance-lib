package com.lapsa.insurance.elements.services.beans;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.services.PhoneTypeService;
import com.lapsa.phone.PhoneType;

@Named("phoneTypeService")
@ApplicationScoped
public class DefaultPhoneTypeService extends GenericEnumService<PhoneType> implements PhoneTypeService {

    public List<PhoneType> getAllItems() {
	return CollectionUtils.toList(PhoneType.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return PhoneType.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return PhoneType.BUNDLE_VAR;
    }
}
