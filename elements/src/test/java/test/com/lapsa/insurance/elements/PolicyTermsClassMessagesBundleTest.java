package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.PolicyTermClass;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class PolicyTermsClassMessagesBundleTest
	extends EnumTypeMessagesBundleTest<PolicyTermClass> {

    @Override
    protected PolicyTermClass[] getAllEnumValues() {
	return PolicyTermClass.values();
    }

    @Override
    protected String getBundleBaseName() {
	return PolicyTermClass.BUNDLE_BASENAME;
    }
}
