package com.lapsa.insurance.services.elements.beans;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.WhoIsInsurant;
import com.lapsa.insurance.services.elements.WhoIsInsurantService;

@Named("whoIsInsurantService")
@ApplicationScoped
public class DefaultWhoIsInsurantService extends GenericEnumService<WhoIsInsurant> implements WhoIsInsurantService {

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
