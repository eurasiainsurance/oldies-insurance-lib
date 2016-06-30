package com.lapsa.insurance.services.crm.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.crm.PaymentStatus;
import com.lapsa.insurance.services.crm.PaymentStatusService;
import com.lapsa.insurance.services.elements.beans.GenericEnumService;

@Named("paymentStatusService")
@ApplicationScoped
public class DefaultPaymentStatusService extends GenericEnumService<PaymentStatus> implements PaymentStatusService {

    @Override
    public List<PaymentStatus> getAllItems() {
	return Arrays.asList(PaymentStatus.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return PaymentStatus.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return PaymentStatus.BUNDLE_VAR;
    }
}
