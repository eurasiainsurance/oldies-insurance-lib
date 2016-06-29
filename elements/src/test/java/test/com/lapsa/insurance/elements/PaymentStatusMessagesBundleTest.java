package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.PaymentStatus;

public class PaymentStatusMessagesBundleTest extends EnumTypeMessagesBundleTest<PaymentStatus> {

    @Override
    protected PaymentStatus[] getAllEnumValues() {
	return PaymentStatus.values();
    }

    @Override
    protected String getBundleBaseName() {
	return PaymentStatus.BUNDLE_BASENAME;
    }
}
