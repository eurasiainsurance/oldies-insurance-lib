package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.CascoDeductiblePartialDamageRate;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class CascoDeductiblePartialDamageRatesMessagesBundleTest extends EnumTypeMessagesBundleTest<CascoDeductiblePartialDamageRate> {

    @Override
    protected CascoDeductiblePartialDamageRate[] getAllEnumValues() {
	return CascoDeductiblePartialDamageRate.values();
    }

    @Override
    protected String getBundleBaseName() {
	return CascoDeductiblePartialDamageRate.BUNDLE_BASENAME;
    }
}
