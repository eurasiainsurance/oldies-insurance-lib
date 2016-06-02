package com.lapsa.insurance.services.elements.beans;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.PolicyObtainingMethod;
import com.lapsa.insurance.services.elements.PolicyObtainingMethodService;

@Named("policyObtainingMethodService")
@ApplicationScoped
public class DefaultPolicyObtainingMethodService extends GenericEnumService<PolicyObtainingMethod>
	implements PolicyObtainingMethodService {

    public List<PolicyObtainingMethod> getAllItems() {
	return CollectionUtils.toList(PolicyObtainingMethod.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return PolicyObtainingMethod.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return PolicyObtainingMethod.BUNDLE_VAR;
    }
}
