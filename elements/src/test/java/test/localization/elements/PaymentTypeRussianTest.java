package test.localization.elements;

import com.lapsa.insurance.elements.PaymentType;

import test.localization.ElementsLocalizationTest;

public class PaymentTypeRussianTest extends ElementsLocalizationTest<PaymentType> {

    public PaymentTypeRussianTest() {
	super(PaymentType.values(), PaymentType.class, LOCALE_RUSSIAN);
    }
}
