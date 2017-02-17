package test.com.lapsa.insurance.crm;

import com.lapsa.insurance.crm.NotificationChannel;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class NotificationChannelMessagesBundleTest extends EnumTypeMessagesBundleTest<NotificationChannel> {

    @Override
    protected NotificationChannel[] getAllEnumValues() {
	return NotificationChannel.values();
    }

    @Override
    protected String getBundleBaseName() {
	return NotificationChannel.BUNDLE_BASENAME;
    }
}
