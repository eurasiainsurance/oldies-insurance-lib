package test.com.lapsa.insurance.elements.casco;

import com.lapsa.insurance.elements.casco.CascoDeductiblePartialDamageRate;

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
