
package com.lapsa.insurance.services.elements.beans;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.services.elements.KZTypeOfSettlementService;
import com.lapsa.kz.country.KZCity;
import com.lapsa.kz.country.KZTypeOfSettlement;

@Named("kzTypeOfSettlement")
@ApplicationScoped
public class DefaultKZTypeOfSettlementService extends GenericEnumService<KZTypeOfSettlement> implements KZTypeOfSettlementService {

    @Override
    public List<KZTypeOfSettlement> getAllItems() {
	return CollectionUtils.toList(KZTypeOfSettlement.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return KZCity.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return KZCity.BUNDLE_VAR;
    }

}
