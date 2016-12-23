package com.lapsa.insurance.dao.filter;

import java.util.Date;

import com.lapsa.insurance.crm.ObtainingStatus;
import com.lapsa.insurance.crm.PaymentStatus;
import com.lapsa.insurance.crm.ProgressStatus;
import com.lapsa.insurance.crm.RequestStatus;
import com.lapsa.insurance.crm.RequestType;
import com.lapsa.insurance.crm.TransactionProblem;
import com.lapsa.insurance.crm.TransactionStatus;
import com.lapsa.insurance.domain.crm.User;
import com.lapsa.insurance.elements.ObtainingMethod;
import com.lapsa.insurance.elements.PaymentMethod;

public interface InsuranceRequestFitler {

    String getIdMask();

    String getRequesterNameMask();

    RequestStatus getRequestStatus();

    RequestType getRequestType();

    PaymentMethod getPaymentMethod();

    PaymentStatus getPaymentStatus();

    ObtainingMethod getObtainingMethod();

    ObtainingStatus getObtainingStatus();

    ProgressStatus getProgressStatus();

    TransactionStatus getTransactionStatus();

    TransactionProblem getTransactionProblem();

    Date getCreatedAfter();

    Date getCreatedBefore();

    Date getCompletedAfter();

    Date getCompletedBefore();

    User getAcceptedBy();

    User getCompletedBy();
}
