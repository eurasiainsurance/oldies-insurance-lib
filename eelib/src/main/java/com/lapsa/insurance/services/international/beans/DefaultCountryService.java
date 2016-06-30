package com.lapsa.insurance.services.international.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.country.Country;
import com.lapsa.insurance.services.elements.beans.GenericEnumService;
import com.lapsa.insurance.services.international.CountryService;

@Named("countryService")
@ApplicationScoped
public class DefaultCountryService extends GenericEnumService<Country> implements CountryService {

    @Override
    public List<Country> getAllItems() {
	return Arrays.asList(Country.values());
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
