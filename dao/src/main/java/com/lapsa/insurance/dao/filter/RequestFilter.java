package com.lapsa.insurance.dao.filter;

import java.time.LocalDateTime;

import com.lapsa.insurance.crm.InsuranceRequestType;
import com.lapsa.insurance.crm.ObtainingStatus;
import com.lapsa.insurance.crm.PaymentStatus;
import com.lapsa.insurance.crm.ProgressStatus;
import com.lapsa.insurance.crm.RequestStatus;
import com.lapsa.insurance.crm.TransactionProblem;
import com.lapsa.insurance.crm.TransactionStatus;
import com.lapsa.insurance.domain.crm.User;
import com.lapsa.insurance.elements.ObtainingMethod;
import com.lapsa.insurance.elements.PaymentMethod;

public interface RequestFilter {

    // Request properties

    Integer getId();

    String getRequesterNameMask();

    String getRequesterIdNumberMask();

    RequestStatus getRequestStatus();

    ProgressStatus getProgressStatus();

    LocalDateTime getCreatedAfter();

    LocalDateTime getCreatedBefore();

    LocalDateTime getCompletedAfter();

    LocalDateTime getCompletedBefore();

    User getCreatedBy();

    User getAcceptedBy();

    User getCompletedBy();

    User getClosedBy();

    // InsuranceRequest properties

    InsuranceRequestType getRequestType();

    PaymentMethod getPaymentMethod();

    PaymentStatus getPaymentStatus();

    ObtainingMethod getObtainingMethod();

    ObtainingStatus getObtainingStatus();

    TransactionStatus getTransactionStatus();

    TransactionProblem getTransactionProblem();

}
