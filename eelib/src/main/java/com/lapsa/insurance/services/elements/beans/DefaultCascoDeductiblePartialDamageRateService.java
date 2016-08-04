package com.lapsa.insurance.services.elements.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.CascoDeductiblePartialDamageRate;
import com.lapsa.insurance.services.elements.CascoDeductiblePartialDamageRateService;

@Named("cascoDeductiblePartialDamageRateService")
@ApplicationScoped
public class DefaultCascoDeductiblePartialDamageRateService extends GenericEnumService<CascoDeductiblePartialDamageRate>
	implements CascoDeductiblePartialDamageRateService {

    public List<CascoDeductiblePartialDamageRate> getAllItems() {
	return Arrays.asList(CascoDeductiblePartialDamageRate.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return CascoDeductiblePartialDamageRate.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return CascoDeductiblePartialDamageRate.BUNDLE_VAR;
    }
}
