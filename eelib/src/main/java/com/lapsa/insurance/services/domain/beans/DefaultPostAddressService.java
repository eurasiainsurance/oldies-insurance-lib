package com.lapsa.insurance.services.domain.beans;

import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.lapsa.insurance.domain.PostAddress;
import com.lapsa.insurance.services.domain.PostAddressService;
import com.lapsa.insurance.services.elements.KZCityService;
import com.lapsa.localization.LocalizationLanguage;

@Named("postAddressService")
@ApplicationScoped
public class DefaultPostAddressService extends GenericDomainService<PostAddress>
	implements PostAddressService {

    @Inject
    private KZCityService kzCityService;

    @Override
    public String displayName(PostAddress value) {
	String city = kzCityService.displayName(value.getCity());
	String street = generateStreet(value);
	return generateDisplayName(value.getPostIndex(), city, street);
    }

    @Override
    public String displayName(PostAddress value, Locale locale) {
	String city = kzCityService.displayName(value.getCity(), locale);
	String street = generateStreet(value, locale);
	return generateDisplayName(value.getPostIndex(), city, street);
    }

    private String generateStreet(PostAddress value, Locale locale) {
	LocalizationLanguage lang = LocalizationLanguage.byTag(locale.getLanguage());
	if (lang != null && value.getStreetLocalization().containsKey(lang))
	    return value.getStreetLocalization().get(lang);
	return value.getStreet();
    }

    private String generateStreet(PostAddress value) {
	FacesContext facesContext = FacesContext.getCurrentInstance();
	Locale locale = facesContext.getViewRoot().getLocale();
	return generateStreet(value, locale);
    }

    private String generateDisplayName(String postIndex, String city, String street) {
	StringBuffer sb = new StringBuffer();
	if (postIndex != null)
	    sb.append(postIndex + ", ");
	if (city != null)
	    sb.append(city + ", ");
	if (street != null)
	    sb.append(street);
	return sb.toString();
    }
}
