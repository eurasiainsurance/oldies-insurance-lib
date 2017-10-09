package test.localization.elements;

import com.lapsa.insurance.elements.PaymentMethod;

import test.localization.ElementsLocalizationTest;

public class PaymentMethodKazakhTest extends ElementsLocalizationTest<PaymentMethod> {

    public PaymentMethodKazakhTest() {
	super(PaymentMethod.values(), PaymentMethod.class, LOCALE_KAZAKH);
    }
}
