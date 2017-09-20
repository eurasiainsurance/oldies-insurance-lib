package test.com.lapsa.insurance.crm;

import com.lapsa.insurance.crm.PaymentStatus;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class PaymentStatusMessagesBundleTest extends EnumTypeMessagesBundleTest<PaymentStatus> {

    @Override
    protected PaymentStatus[] getAllEnumValues() {
	return PaymentStatus.values();
    }
}
