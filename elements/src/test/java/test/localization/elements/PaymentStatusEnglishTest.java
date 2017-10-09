package test.localization.elements;

import com.lapsa.insurance.elements.PaymentStatus;

import test.localization.ElementsLocalizationTest;

public class PaymentStatusEnglishTest extends ElementsLocalizationTest<PaymentStatus> {

    public PaymentStatusEnglishTest() {
	super(PaymentStatus.values(), PaymentStatus.class, LOCALE_ENGLISH);
    }
}
