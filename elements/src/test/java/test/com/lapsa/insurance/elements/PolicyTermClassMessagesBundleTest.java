package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.PolicyTermClass;

public class PolicyTermClassMessagesBundleTest
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
