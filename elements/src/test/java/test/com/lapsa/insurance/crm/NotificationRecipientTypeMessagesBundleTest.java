package test.com.lapsa.insurance.crm;

import com.lapsa.insurance.crm.NotificationRecipientType;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class NotificationRecipientTypeMessagesBundleTest extends EnumTypeMessagesBundleTest<NotificationRecipientType> {

    @Override
    protected NotificationRecipientType[] getAllEnumValues() {
	return NotificationRecipientType.values();
    }

    @Override
    protected String getBundleBaseName() {
	return NotificationRecipientType.BUNDLE_BASENAME;
    }
}
