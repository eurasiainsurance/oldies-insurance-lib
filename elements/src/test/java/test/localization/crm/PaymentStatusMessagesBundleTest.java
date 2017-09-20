package test.localization.crm;

import com.lapsa.insurance.elements.PaymentStatus;

import test.localization.EnumTypeMessagesBundleTest;

public class PaymentStatusMessagesBundleTest extends EnumTypeMessagesBundleTest<PaymentStatus> {

    @Override
    protected PaymentStatus[] getAllEnumValues() {
	return PaymentStatus.values();
    }
}
