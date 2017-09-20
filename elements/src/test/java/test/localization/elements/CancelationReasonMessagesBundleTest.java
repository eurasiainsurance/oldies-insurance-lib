package test.localization.elements;

import com.lapsa.insurance.elements.CancelationReason;

import test.localization.EnumTypeMessagesBundleTest;

public class CancelationReasonMessagesBundleTest extends EnumTypeMessagesBundleTest<CancelationReason> {

    @Override
    protected CancelationReason[] getAllEnumValues() {
	return CancelationReason.values();
    }
}
