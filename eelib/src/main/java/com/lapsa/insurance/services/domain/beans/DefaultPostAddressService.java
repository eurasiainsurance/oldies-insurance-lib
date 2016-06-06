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
	String city = kzCityService.displayName(value.getCity());
	return generateDisplayName(value.getPostIndex(), city, value.getStreet());
    }

    @Override
    public String displayName(PostAddress value, Locale locale) {
	String city = kzCityService.displayName(value.getCity(), locale);
	return generateDisplayName(value.getPostIndex(), city, value.getStreet());
    }

    private String generateDisplayName(String postIndex, String city, String address) {
	StringBuffer sb = new StringBuffer();
	if (postIndex != null)
	    sb.append(postIndex + ", ");
	if (city != null)
	    sb.append(city + ", ");
	if (address != null)
	    sb.append(address);
	return sb.toString();
    }
}
