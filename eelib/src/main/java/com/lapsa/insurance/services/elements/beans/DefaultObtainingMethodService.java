package com.lapsa.insurance.services.elements.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.ObtainingMethod;
import com.lapsa.insurance.services.elements.ObtainingMethodService;

@Named("policyObtainingMethodService")
@ApplicationScoped
public class DefaultObtainingMethodService extends GenericEnumService<ObtainingMethod>
	implements ObtainingMethodService {

    public List<ObtainingMethod> getAllItems() {
	return Arrays.asList(ObtainingMethod.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return ObtainingMethod.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return ObtainingMethod.BUNDLE_VAR;
    }
}
