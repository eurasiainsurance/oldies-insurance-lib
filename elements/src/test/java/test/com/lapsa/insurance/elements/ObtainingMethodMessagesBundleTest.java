package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.ObtainingMethod;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class PolicyObtainingMethodMessagesBundleTest extends EnumTypeMessagesBundleTest<ObtainingMethod> {

    @Override
    protected ObtainingMethod[] getAllEnumValues() {
	return ObtainingMethod.values();
    }

    @Override
    protected String getBundleBaseName() {
	return ObtainingMethod.BUNDLE_BASENAME;
    }
}
