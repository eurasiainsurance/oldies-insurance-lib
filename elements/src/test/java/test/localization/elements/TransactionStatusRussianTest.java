package test.localization.elements;

import com.lapsa.insurance.elements.TransactionStatus;

import test.localization.ElementsLocalizationTest;

public class TransactionStatusRussianTest extends ElementsLocalizationTest<TransactionStatus> {

    public TransactionStatusRussianTest() {
	super(TransactionStatus.values(), TransactionStatus.class, LOCALE_RUSSIAN);
    }
}
