package test.localization.elements;

import com.lapsa.insurance.elements.PaymentMethod;

import test.localization.ElementsLocalizationTest;

public class PaymentMethodEnglishTest extends ElementsLocalizationTest<PaymentMethod> {

    public PaymentMethodEnglishTest() {
	super(PaymentMethod.values(), PaymentMethod.class, LOCALE_ENGLISH);
    }
}
