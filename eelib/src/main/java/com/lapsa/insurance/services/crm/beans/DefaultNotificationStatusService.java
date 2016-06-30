package com.lapsa.insurance.services.crm.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.crm.NotificationStatus;
import com.lapsa.insurance.services.crm.NotificationStatusService;
import com.lapsa.insurance.services.elements.beans.GenericEnumService;

@Named("notificationStatusService")
@ApplicationScoped
public class DefaultNotificationStatusService extends GenericEnumService<NotificationStatus> implements NotificationStatusService {

    @Override
    public List<NotificationStatus> getAllItems() {
	return Arrays.asList(NotificationStatus.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return NotificationStatus.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return NotificationStatus.BUNDLE_VAR;
    }
}
