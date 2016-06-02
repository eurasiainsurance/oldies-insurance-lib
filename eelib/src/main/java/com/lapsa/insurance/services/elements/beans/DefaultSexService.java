package com.lapsa.insurance.services.elements.beans;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.Sex;
import com.lapsa.insurance.services.elements.SexService;

@Named("SexService")
@ApplicationScoped
public class DefaultSexService extends GenericEnumService<Sex> implements SexService {

    public List<Sex> getAllItems() {
	return CollectionUtils.toList(Sex.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return Sex.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return Sex.BUNDLE_VAR;
    }
}
