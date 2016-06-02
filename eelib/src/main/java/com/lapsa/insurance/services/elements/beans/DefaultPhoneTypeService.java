package com.lapsa.insurance.services.elements.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.services.elements.PhoneTypeService;
import com.lapsa.phone.PhoneType;

@Named("phoneTypeService")
@ApplicationScoped
public class DefaultPhoneTypeService extends GenericEnumService<PhoneType> implements PhoneTypeService {

    public List<PhoneType> getAllItems() {
	return Arrays.asList(PhoneType.values());
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
