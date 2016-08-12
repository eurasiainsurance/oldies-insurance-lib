package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.CascoDeductibleFullRate;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class CascoDeductibleFullDeathRatesMessagesBundleTest extends EnumTypeMessagesBundleTest<CascoDeductibleFullRate> {

    @Override
    protected CascoDeductibleFullRate[] getAllEnumValues() {
	return CascoDeductibleFullRate.values();
    }

    @Override
    protected String getBundleBaseName() {
	return CascoDeductibleFullRate.BUNDLE_BASENAME;
    }
}
