package test.com.lapsa.insurance.crm;

import com.lapsa.insurance.crm.RequestNotificationType;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class RequestNotificationTypeMessagesBundleTest extends EnumTypeMessagesBundleTest<RequestNotificationType> {

    @Override
    protected RequestNotificationType[] getAllEnumValues() {
	return RequestNotificationType.values();
    }

    @Override
    protected String getBundleBaseName() {
	return RequestNotificationType.BUNDLE_BASENAME;
    }
}
