package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.TermClass;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class PolicyTermsClassMessagesBundleTest
	extends EnumTypeMessagesBundleTest<TermClass> {

    @Override
    protected TermClass[] getAllEnumValues() {
	return TermClass.values();
    }

    @Override
    protected String getBundleBaseName() {
	return TermClass.BUNDLE_BASENAME;
    }
}
