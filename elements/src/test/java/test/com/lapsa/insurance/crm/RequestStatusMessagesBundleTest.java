package test.com.lapsa.insurance.crm;

import com.lapsa.insurance.crm.RequestStatus;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class RequestStatusMessagesBundleTest extends EnumTypeMessagesBundleTest<RequestStatus> {

    @Override
    protected RequestStatus[] getAllEnumValues() {
	return RequestStatus.values();
    }
}
