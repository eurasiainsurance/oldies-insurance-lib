package com.lapsa.insurance.persistence.dao.filter;

import com.lapsa.insurance.crm.ObtainingStatus;
import com.lapsa.insurance.crm.PaymentStatus;
import com.lapsa.insurance.crm.ProgressStatus;
import com.lapsa.insurance.crm.RequestStatus;
import com.lapsa.insurance.crm.RequestType;
import com.lapsa.insurance.crm.TransactionProblem;
import com.lapsa.insurance.crm.TransactionStatus;
import com.lapsa.insurance.elements.ObtainingMethod;
import com.lapsa.insurance.elements.PaymentMethod;

public interface InsuranceRequestFitler {

    RequestStatus getRequestStatus();

    RequestType getRequestType();

    PaymentMethod getPaymentMethod();

    PaymentStatus getPaymentStatus();

    ObtainingMethod getObtainingMethod();

    ObtainingStatus getObtainingStatus();

    ProgressStatus getProgressStatus();

    TransactionStatus getTransactionStatus();

    TransactionProblem getTransactionProblem();
}
