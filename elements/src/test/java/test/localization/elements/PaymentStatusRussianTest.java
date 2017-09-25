package test.localization.elements;

import com.lapsa.insurance.elements.PaymentStatus;

import test.localization.ElementsLocalizationTest;

public class PaymentStatusRussianTest extends ElementsLocalizationTest<PaymentStatus> {

    public PaymentStatusRussianTest() {
	super(PaymentStatus.values(), PaymentStatus.class, LOCALE_RUSSIAN);
    }
}
