
package com.lapsa.insurance.elements.services;

import java.util.List;

import javax.faces.model.SelectItem;

import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;

public interface KZCityService extends ItemService<KZCity> {
    List<KZCity> selectableItemsByArea(KZArea area);

    List<SelectItem> regionalItemsByAreaSI(KZArea area);

    List<KZCity> regionalItemsByArea(KZArea area);

    List<SelectItem> selectableItemsByAreaSI(KZArea area);
}
