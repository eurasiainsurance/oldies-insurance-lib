package test.localization.elements;

import com.lapsa.insurance.elements.ContractStatus;

import test.localization.ElementsLocalizationTest;

public class ContractStatusKazakhTest extends ElementsLocalizationTest<ContractStatus> {

    public ContractStatusKazakhTest() {
	super(ContractStatus.values(), ContractStatus.class, LOCALE_KAZAKH);
    }
}
