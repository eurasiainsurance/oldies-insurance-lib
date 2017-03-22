package com.lapsa.insurance.dao.filter;

import com.lapsa.insurance.crm.InsuranceRequestType;
import com.lapsa.insurance.crm.ObtainingStatus;
import com.lapsa.insurance.crm.PaymentStatus;
import com.lapsa.insurance.crm.TransactionProblem;
import com.lapsa.insurance.crm.TransactionStatus;
import com.lapsa.insurance.elements.InsuranceProductType;
import com.lapsa.insurance.elements.ObtainingMethod;
import com.lapsa.insurance.elements.PaymentMethod;

public interface InsuranceRequestFilter {
    InsuranceRequestType getRequestType();

    PaymentMethod getPaymentMethod();

    PaymentStatus getPaymentStatus();

    ObtainingMethod getObtainingMethod();

    ObtainingStatus getObtainingStatus();

    InsuranceProductType getInsuranceProductType();

    TransactionStatus getTransactionStatus();

    TransactionProblem getTransactionProblem();
}
