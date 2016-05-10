package com.lapsa.insurance.elements.services.inject;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.Sex;
import com.lapsa.insurance.elements.services.SexService;

@Named("SexService")
@ApplicationScoped
public class DefaultSexService extends EnumService<Sex> implements SexService {

    public List<Sex> getAllItems() {
	return CollectionUtils.toList(Sex.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return Sex.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleName() {
	return Sex.BUNDLE_VAR;
    }
}
