package kz.theeurasia.policy.services.inject;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.country.Country;

import kz.theeurasia.policy.services.CountryService;

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
    protected String getMessageBundleName() {
	return Country.BUNDLE_VAR;
    }

}
