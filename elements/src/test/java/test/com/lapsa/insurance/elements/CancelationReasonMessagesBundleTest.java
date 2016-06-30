package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.CancelationReason;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class CancelationReasonMessagesBundleTest extends EnumTypeMessagesBundleTest<CancelationReason>{

    @Override
    protected CancelationReason[] getAllEnumValues() {
	return CancelationReason.values();
    }

    @Override
    protected String getBundleBaseName() {
	return CancelationReason.BUNDLE_BASENAME;
    }
}
