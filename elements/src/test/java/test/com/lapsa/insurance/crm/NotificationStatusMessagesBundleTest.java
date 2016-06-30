package test.com.lapsa.insurance.crm;

import com.lapsa.insurance.crm.NotificationStatus;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class NotificationStatusMessagesBundleTest extends EnumTypeMessagesBundleTest<NotificationStatus> {

    @Override
    protected NotificationStatus[] getAllEnumValues() {
	return NotificationStatus.values();
    }

    @Override
    protected String getBundleBaseName() {
	return NotificationStatus.BUNDLE_BASENAME;
    }
}
