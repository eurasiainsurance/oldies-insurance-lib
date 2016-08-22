package com.lapsa.insurance.persistence.dao.filter;

import com.lapsa.insurance.crm.ClosingResult;
import com.lapsa.insurance.crm.PaymentStatus;
import com.lapsa.insurance.crm.RequestStatus;
import com.lapsa.insurance.elements.ObtainingMethod;
import com.lapsa.insurance.elements.PaymentMethod;

public interface InsuranceRequestFitler {

    RequestStatus getRequestStatus();

    PaymentMethod getPaymentMethod();

    PaymentStatus getPaymentStatus();

    ObtainingMethod getObtainingMethod();
    
    ClosingResult getClosingResult();
}
