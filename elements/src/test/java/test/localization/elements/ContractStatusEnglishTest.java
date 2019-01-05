package test.localization.elements;

import com.lapsa.insurance.elements.TransactionStatus;

import test.localization.ElementsLocalizationTest;

public class TransactionStatusEnglishTest extends ElementsLocalizationTest<TransactionStatus> {

    public TransactionStatusEnglishTest() {
	super(TransactionStatus.values(), TransactionStatus.class, LOCALE_ENGLISH);
    }
}
