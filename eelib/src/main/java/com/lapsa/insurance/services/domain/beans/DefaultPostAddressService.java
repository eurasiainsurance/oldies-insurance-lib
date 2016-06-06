package com.lapsa.insurance.services.domain.beans;

import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lapsa.insurance.domain.PostAddress;
import com.lapsa.insurance.services.domain.PostAddressService;
import com.lapsa.insurance.services.elements.KZCityService;

@Named("postAddressService")
@ApplicationScoped
public class DefaultPostAddressService extends GenericDomainService<PostAddress>
	implements PostAddressService {

    @Inject
    private KZCityService kzCityService;

    @Override
    public String displayName(PostAddress value) {
	StringBuffer sb = new StringBuffer();
	if (value.getPostIndex() != null)
	    sb.append(value.getPostIndex() + ", ");
	if (value.getCity() != null)
	    sb.append(kzCityService.displayName(value.getCity()) + ", ");
	if (value.getStreet() != null)
	    sb.append(value.getStreet());
	return sb.toString();
    }

    @Override
    public String displayName(PostAddress value, Locale locale) {
	return displayName(value);
    }
}
