package test.com.lapsa.insurance.crm;

import com.lapsa.insurance.crm.RequestType;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class RequestTypeMessagesBundleTest extends EnumTypeMessagesBundleTest<RequestType> {

    @Override
    protected RequestType[] getAllEnumValues() {
	return RequestType.values();
    }

    @Override
    protected String getBundleBaseName() {
	return RequestType.BUNDLE_BASENAME;
    }
}
