
package com.lapsa.insurance.services.kz;

import java.util.List;

import javax.faces.model.SelectItem;

import com.lapsa.insurance.services.EnumService;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;

public interface KZCityService extends EnumService<KZCity> {

    List<KZCity> selectableItemsByArea(KZArea area);

    List<SelectItem> regionalItemsByAreaSI(KZArea area);

    List<KZCity> regionalItemsByArea(KZArea area);

    List<SelectItem> selectableItemsByAreaSI(KZArea area);
}
