package test.localization.elements;

import com.lapsa.insurance.elements.ContractStatus;

import test.localization.ElementsLocalizationTest;

public class ContractStatusEnglishTest extends ElementsLocalizationTest<ContractStatus> {

    public ContractStatusEnglishTest() {
	super(ContractStatus.values(), ContractStatus.class, LOCALE_ENGLISH);
    }
}
