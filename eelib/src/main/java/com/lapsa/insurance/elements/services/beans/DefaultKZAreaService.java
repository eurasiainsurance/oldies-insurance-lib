package com.lapsa.insurance.elements.services.beans;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.elements.services.KZAreaService;
import com.lapsa.kz.country.KZArea;

@Named("kzAreaService")
@ApplicationScoped
public class DefaultKZAreaService extends GenericEnumService<KZArea> implements KZAreaService {

    public List<KZArea> getAllItems() {
	return CollectionUtils.toList(KZArea.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return KZArea.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return KZArea.BUNDLE_VAR;
    }
}
