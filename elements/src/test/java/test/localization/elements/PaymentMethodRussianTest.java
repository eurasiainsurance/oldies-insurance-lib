package test.localization.elements;

import com.lapsa.insurance.elements.PaymentMethod;

import test.localization.ElementsLocalizationTest;

public class PaymentMethodRussianTest extends ElementsLocalizationTest<PaymentMethod> {

    public PaymentMethodRussianTest() {
	super(PaymentMethod.values(), PaymentMethod.class, LOCALE_RUSSIAN);
    }
}
