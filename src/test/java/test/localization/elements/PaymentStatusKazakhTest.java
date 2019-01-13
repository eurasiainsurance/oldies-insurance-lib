package test.localization.elements;

import com.lapsa.insurance.elements.PaymentStatus;

import test.localization.ElementsLocalizationTest;

public class PaymentStatusKazakhTest extends ElementsLocalizationTest<PaymentStatus> {

    public PaymentStatusKazakhTest() {
	super(PaymentStatus.values(), PaymentStatus.class, LOCALE_KAZAKH);
    }
}
