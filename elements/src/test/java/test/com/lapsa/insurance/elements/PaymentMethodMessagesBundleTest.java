package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.PaymentMethod;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class PaymentMethodMessagesBundleTest extends EnumTypeMessagesBundleTest<PaymentMethod> {

    @Override
    protected PaymentMethod[] getAllEnumValues() {
	return PaymentMethod.values();
    }

    @Override
    protected String getBundleBaseName() {
	return PaymentMethod.BUNDLE_BASENAME;
    }
}
