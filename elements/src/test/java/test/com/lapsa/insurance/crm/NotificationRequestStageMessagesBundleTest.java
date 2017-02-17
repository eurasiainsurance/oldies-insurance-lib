package test.com.lapsa.insurance.crm;

import com.lapsa.insurance.crm.NotificationRequestStage;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class NotificationRequestStageMessagesBundleTest extends EnumTypeMessagesBundleTest<NotificationRequestStage> {

    @Override
    protected NotificationRequestStage[] getAllEnumValues() {
	return NotificationRequestStage.values();
    }

    @Override
    protected String getBundleBaseName() {
	return NotificationRequestStage.BUNDLE_BASENAME;
    }
}
