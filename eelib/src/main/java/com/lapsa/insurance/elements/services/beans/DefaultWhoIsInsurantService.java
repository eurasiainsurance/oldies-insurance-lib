package com.lapsa.insurance.elements.services.beans;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.WhoIsInsurant;
import com.lapsa.insurance.elements.services.WhoIsInsurantService;

@Named("whoIsInsurantService")
@ApplicationScoped
public class DefaultWhoIsInsurantService extends EnumService<WhoIsInsurant> implements WhoIsInsurantService {

    public List<WhoIsInsurant> getAllItems() {
	return CollectionUtils.toList(WhoIsInsurant.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return WhoIsInsurant.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return WhoIsInsurant.BUNDLE_VAR;
    }
}
