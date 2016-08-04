package test.com.lapsa.insurance.elements.casco;

import com.lapsa.insurance.elements.casco.CascoDeductibleFullDeathRate;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class CascoDeductibleFullDeathRatesMessagesBundleTest extends EnumTypeMessagesBundleTest<CascoDeductibleFullDeathRate> {

    @Override
    protected CascoDeductibleFullDeathRate[] getAllEnumValues() {
	return CascoDeductibleFullDeathRate.values();
    }

    @Override
    protected String getBundleBaseName() {
	return CascoDeductibleFullDeathRate.BUNDLE_BASENAME;
    }
}
