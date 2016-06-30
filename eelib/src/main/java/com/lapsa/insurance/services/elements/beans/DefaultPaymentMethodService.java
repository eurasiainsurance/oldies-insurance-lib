package com.lapsa.insurance.services.elements.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.PaymentMethod;
import com.lapsa.insurance.services.elements.PaymentMethodService;

@Named("paymentMethodService")
@ApplicationScoped
public class DefaultPaymentMethodService extends GenericEnumService<PaymentMethod>
	implements PaymentMethodService {

    public List<PaymentMethod> getAllItems() {
	return Arrays.asList(PaymentMethod.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return PaymentMethod.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return PaymentMethod.BUNDLE_VAR;
    }
}
