package test.localization.elements;

import com.lapsa.insurance.elements.CascoDeductiblePartialRate;

import test.localization.EnumTypeMessagesBundleTest;

public class CascoDeductiblePartialDamageRatesMessagesBundleTest
	extends EnumTypeMessagesBundleTest<CascoDeductiblePartialRate> {

    @Override
    protected CascoDeductiblePartialRate[] getAllEnumValues() {
	return CascoDeductiblePartialRate.values();
    }
}
