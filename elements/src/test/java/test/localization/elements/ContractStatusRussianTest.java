package test.localization.elements;

import com.lapsa.insurance.elements.ContractStatus;

import test.localization.ElementsLocalizationTest;

public class ContractStatusRussianTest extends ElementsLocalizationTest<ContractStatus> {

    public ContractStatusRussianTest() {
	super(ContractStatus.values(), ContractStatus.class, LOCALE_RUSSIAN);
    }
}
