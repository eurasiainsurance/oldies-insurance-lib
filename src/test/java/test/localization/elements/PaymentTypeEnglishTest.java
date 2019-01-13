package test.localization.elements;

import com.lapsa.insurance.elements.PaymentType;

import test.localization.ElementsLocalizationTest;

public class PaymentTypeEnglishTest extends ElementsLocalizationTest<PaymentType> {

    public PaymentTypeEnglishTest() {
	super(PaymentType.values(), PaymentType.class, LOCALE_ENGLISH);
    }
}
