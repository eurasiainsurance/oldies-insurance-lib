package test.localization.elements;

import com.lapsa.insurance.elements.TransactionProblem;

import test.localization.ElementsLocalizationTest;

public class TransactionProblemEnglishTest extends ElementsLocalizationTest<TransactionProblem> {

    public TransactionProblemEnglishTest() {
	super(TransactionProblem.values(), TransactionProblem.class, LOCALE_ENGLISH);
    }
}
