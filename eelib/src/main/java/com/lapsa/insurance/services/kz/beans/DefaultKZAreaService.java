package com.lapsa.insurance.services.kz.beans;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.insurance.services.elements.beans.GenericEnumService;
import com.lapsa.insurance.services.kz.KZAreaService;
import com.lapsa.kz.country.KZArea;

@Named("kzAreaService")
@ApplicationScoped
public class DefaultKZAreaService extends GenericEnumService<KZArea> implements KZAreaService {

    public List<KZArea> getAllItems() {
	return Arrays.asList(KZArea.values());
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
