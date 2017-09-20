package test.localization.crm;

import com.lapsa.insurance.crm.RequestSource;

import test.localization.EnumTypeMessagesBundleTest;

public class RequestSourceMessagesBundleTest extends EnumTypeMessagesBundleTest<RequestSource> {

    @Override
    protected RequestSource[] getAllEnumValues() {
	return RequestSource.values();
    }
}
