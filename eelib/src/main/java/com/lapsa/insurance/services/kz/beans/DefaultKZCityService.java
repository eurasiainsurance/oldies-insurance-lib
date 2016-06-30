
package com.lapsa.insurance.services.kz.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.lapsa.insurance.services.elements.beans.GenericEnumService;
import com.lapsa.insurance.services.kz.KZCityService;
import com.lapsa.insurance.services.kz.KZTypeOfSettlementService;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;
import com.lapsa.localization.LocalizationLanguage;

@Named("kzCityService")
@ApplicationScoped
public class DefaultKZCityService extends GenericEnumService<KZCity> implements KZCityService {

    @Inject
    private KZTypeOfSettlementService kzTypeOfSettlementService;

    @Override
    public List<KZCity> getAllItems() {
	return Arrays.asList(KZCity.values());
    }

    @Override
    public List<KZCity> selectableItemsByArea(KZArea area) {
	List<KZCity> result = new ArrayList<>();
	for (KZCity city : KZCity.values())
	    if (area == null || city.getArea().equals(area))
		result.add(city);
	return result;
    }

    @Override
    public List<SelectItem> regionalItemsByAreaSI(KZArea area) {
	return displayNamesSI(regionalItemsByArea(area));
    }

    @Override
    public List<KZCity> regionalItemsByArea(KZArea area) {
	List<KZCity> result = new ArrayList<>();
	for (KZCity city : KZCity.values()) {
	    if (city.getArea() == null)
		continue;
	    if (!isRegional(city))
		continue;
	    if (area == null || city.getArea().equals(area))
		result.add(city);
	}
	result.add(KZCity.OTHER);
	return result;
    }

    @Override
    public List<SelectItem> selectableItemsByAreaSI(KZArea area) {
	return displayNamesSI(selectableItemsByArea(area));
    }

    @Override
    protected String getMessageBundleBase() {
	return KZCity.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleVar() {
	return KZCity.BUNDLE_VAR;
    }

    @Override
    public String displayName(KZCity value) {
	if (value == null)
	    return null;
	String typeOfSettlementName = kzTypeOfSettlementService.enumNameLocalizedShort(value.getTypeOfSettlement());
	String cityName = enumNameLocalized(value);
	return generateDisplayName(typeOfSettlementName, cityName);
    }

    @Override
    public String displayName(KZCity value, Locale locale) {
	if (value == null)
	    return null;
	String typeOfSettlementName = kzTypeOfSettlementService.enumNameLocalizedShort(value.getTypeOfSettlement(),
		locale);
	String cityName = enumNameLocalized(value, locale);
	return generateDisplayName(typeOfSettlementName, cityName, locale);
    }

    // PRIVATE & PROTECTED

    private String generateDisplayName(String typeOfSettlementName, String cityName) {
	return generateDisplayName(typeOfSettlementName, cityName,
		FacesContext.getCurrentInstance().getViewRoot().getLocale());
    }

    private String generateDisplayName(String typeOfSettlementName, String cityName, Locale locale) {
	return generateDisplayName(typeOfSettlementName, cityName, LocalizationLanguage.byLocale(locale));
    }

    private String generateDisplayName(String typeOfSettlement, String city, LocalizationLanguage language) {
	StringBuffer sb = new StringBuffer();
	switch (language) {
	case ENGLISH:
	    sb.append(city);
	    break;
	case KAZAKH:
	    sb.append(city);
	    if (typeOfSettlement != null) {
		sb.append(" ");
		sb.append(typeOfSettlement);
	    }
	    break;
	case RUSSIAN:
	default:
	    if (typeOfSettlement != null) {
		sb.append(typeOfSettlement);
		sb.append(" ");
	    }
	    sb.append(city);
	    break;
	}
	return sb.toString();
    }

    private boolean isRegional(KZCity city) {
	if (city == null || city.getType() == null)
	    return false;
	switch (city.getType()) {
	case MAJOR:
	case REGIONAL_CENTER:
	case REGIONAL_SUBORDINATION:
	    return true;
	default:
	}
	return false;
    }
}
