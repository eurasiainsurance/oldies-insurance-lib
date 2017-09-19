package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.CascoDeductiblePartialRate;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class CascoDeductiblePartialDamageRatesMessagesBundleTest
	extends EnumTypeMessagesBundleTest<CascoDeductiblePartialRate> {

    @Override
    protected CascoDeductiblePartialRate[] getAllEnumValues() {
	return CascoDeductiblePartialRate.values();
    }
}
