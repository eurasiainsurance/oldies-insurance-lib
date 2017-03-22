package com.lapsa.insurance.dao.filter;

import java.util.Date;

import com.lapsa.insurance.crm.ProgressStatus;
import com.lapsa.insurance.crm.RequestStatus;
import com.lapsa.insurance.domain.crm.User;

public interface RequestFilter {

    Integer getId();

    String getRequesterNameMask();

    String getRequesterIdNumberMask();

    RequestStatus getRequestStatus();

    ProgressStatus getProgressStatus();

    Date getCreatedAfter();

    Date getCreatedBefore();

    Date getCompletedAfter();

    Date getCompletedBefore();

    User getAcceptedBy();

    User getCompletedBy();
}
