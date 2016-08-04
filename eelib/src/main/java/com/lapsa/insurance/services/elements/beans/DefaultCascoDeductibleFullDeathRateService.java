package com.lapsa.insurance.services.elements.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.CascoDeductibleFullDeathRate;
import com.lapsa.insurance.services.elements.CascoDeductibleFullDeathRateService;

@Named("cascoDeductibleFullDeathRateService")
@ApplicationScoped
public class DefaultCascoDeductibleFullDeathRateService extends GenericEnumService<CascoDeductibleFullDeathRate>
	implements CascoDeductibleFullDeathRateService {

    public List<CascoDeductibleFullDeathRate> getAllItems() {
	return Arrays.asList(CascoDeductibleFullDeathRate.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return CascoDeductibleFullDeathRate.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return CascoDeductibleFullDeathRate.BUNDLE_VAR;
    }
}
