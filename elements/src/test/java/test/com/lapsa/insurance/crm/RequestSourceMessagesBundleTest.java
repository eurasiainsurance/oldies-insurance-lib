package test.com.lapsa.insurance.crm;

import com.lapsa.insurance.crm.RequestSource;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class RequestSourceMessagesBundleTest extends EnumTypeMessagesBundleTest<RequestSource> {

    @Override
    protected RequestSource[] getAllEnumValues() {
	return RequestSource.values();
    }

    @Override
    protected String getBundleBaseName() {
	return RequestSource.BUNDLE_BASENAME;
    }
}
