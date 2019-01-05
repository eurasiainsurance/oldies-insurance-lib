package test.localization.elements;

import com.lapsa.insurance.elements.TransactionStatus;

import test.localization.ElementsLocalizationTest;

public class TransactionStatusKazakhTest extends ElementsLocalizationTest<TransactionStatus> {

    public TransactionStatusKazakhTest() {
	super(TransactionStatus.values(), TransactionStatus.class, LOCALE_KAZAKH);
    }
}
