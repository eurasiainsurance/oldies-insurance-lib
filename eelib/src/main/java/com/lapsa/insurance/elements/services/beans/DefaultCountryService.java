package com.lapsa.insurance.elements.services.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.country.Country;
import com.lapsa.insurance.elements.services.CountryService;

@Named("countryService")
@ApplicationScoped
public class DefaultCountryService extends EnumService<Country> implements CountryService {

    @Override
    public List<Country> getAllItems() {
	return CollectionUtils.toList(Country.values());
    }

    @Override
    public List<Country> getSelectableItems() {
	List<Country> ret = new ArrayList<>();
	for (Country t : Country.values())
	    if (t.isActual())
		ret.add(t);
	return ret;
    }

    @Override
    protected String getMessageBundleBase() {
	return Country.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return Country.BUNDLE_VAR;
    }

}
