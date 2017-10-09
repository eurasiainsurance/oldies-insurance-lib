package test.localization.elements;

import com.lapsa.insurance.elements.TransactionProblem;

import test.localization.ElementsLocalizationTest;

public class TransactionProblemRussianTest extends ElementsLocalizationTest<TransactionProblem> {

    public TransactionProblemRussianTest() {
	super(TransactionProblem.values(), TransactionProblem.class, LOCALE_RUSSIAN);
    }
}
