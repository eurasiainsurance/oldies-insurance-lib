
package com.lapsa.insurance.elements.services.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import com.lapsa.insurance.elements.services.KZCityService;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;

@Named("kzCityService")
@ApplicationScoped
public class DefaultKZCityService extends EnumService<KZCity> implements KZCityService {

    @Override
    public List<KZCity> getAllItems() {
	return CollectionUtils.toList(KZCity.values());
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
	return localizedSI(regionalItemsByArea(area));
    }

    @Override
    public List<KZCity> regionalItemsByArea(KZArea area) {
	List<KZCity> result = new ArrayList<>();
	for (KZCity city : KZCity.values()) {
	    if (city.getArea() == null) // TODO плохой код. Сделано чтобы OTHER
					// не попадал в список. Исправить
		continue;
	    if (!isRegional(city))
		continue;
	    if (area == null || city.getArea().equals(area))
		result.add(city);
	}
	result.add(KZCity.OTHER); // TODO тоже плохой код. Непонятно, что делать
				  // с этим OTHER
	return result;
    }

    @Override
    public List<SelectItem> selectableItemsByAreaSI(KZArea area) {
	return localizedSI(selectableItemsByArea(area));
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

    @Override
    protected String getMessageBundleBase() {
	return KZCity.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleName() {
	return KZCity.BUNDLE_VAR;
    }

}
