package test.localization.crm;

import com.lapsa.insurance.elements.RequestStatus;

import test.localization.EnumTypeMessagesBundleTest;

public class RequestStatusMessagesBundleTest extends EnumTypeMessagesBundleTest<RequestStatus> {

    @Override
    protected RequestStatus[] getAllEnumValues() {
	return RequestStatus.values();
    }
}
