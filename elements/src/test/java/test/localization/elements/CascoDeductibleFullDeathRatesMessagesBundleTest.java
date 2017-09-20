package test.localization.elements;

import com.lapsa.insurance.elements.CascoDeductibleFullRate;

import test.localization.EnumTypeMessagesBundleTest;

public class CascoDeductibleFullDeathRatesMessagesBundleTest
	extends EnumTypeMessagesBundleTest<CascoDeductibleFullRate> {

    @Override
    protected CascoDeductibleFullRate[] getAllEnumValues() {
	return CascoDeductibleFullRate.values();
    }
}
