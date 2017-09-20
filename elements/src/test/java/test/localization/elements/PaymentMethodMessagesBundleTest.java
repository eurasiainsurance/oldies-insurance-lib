package test.localization.elements;

import com.lapsa.insurance.elements.PaymentMethod;

import test.localization.EnumTypeMessagesBundleTest;

public class PaymentMethodMessagesBundleTest extends EnumTypeMessagesBundleTest<PaymentMethod> {

    @Override
    protected PaymentMethod[] getAllEnumValues() {
	return PaymentMethod.values();
    }
}
