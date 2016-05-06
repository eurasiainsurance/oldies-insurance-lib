package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.PolicyObtainingMethod;

public class PolicyObtainingMethodMessagesBundleTest extends EnumTypeMessagesBundleTest<PolicyObtainingMethod> {

    @Override
    protected PolicyObtainingMethod[] getAllEnumValues() {
	return PolicyObtainingMethod.values();
    }

    @Override
    protected String getBundleBaseName() {
	return PolicyObtainingMethod.BUNDLE_BASENAME;
    }
}
