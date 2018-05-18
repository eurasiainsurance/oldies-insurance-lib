package test.localization.elements;

import com.lapsa.insurance.elements.PaymentType;

import test.localization.ElementsLocalizationTest;

public class PaymentTypeKazakhTest extends ElementsLocalizationTest<PaymentType> {

    public PaymentTypeKazakhTest() {
	super(PaymentType.values(), PaymentType.class, LOCALE_KAZAKH);
    }
}
