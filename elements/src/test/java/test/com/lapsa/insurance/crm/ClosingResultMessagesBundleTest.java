package test.com.lapsa.insurance.crm;

import com.lapsa.insurance.crm.ClosingResult;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class ClosingResultMessagesBundleTest extends EnumTypeMessagesBundleTest<ClosingResult> {

    @Override
    protected ClosingResult[] getAllEnumValues() {
	return ClosingResult.values();
    }

    @Override
    protected String getBundleBaseName() {
	return ClosingResult.BUNDLE_BASENAME;
    }
}
