
package com.lapsa.insurance.services.kz;

import java.util.List;

import javax.faces.model.SelectItem;

import com.lapsa.insurance.services.EnumListingNamingService;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;

public interface KZCityService extends EnumListingNamingService<KZCity> {

    List<KZCity> selectableItemsByArea(KZArea area);

    List<SelectItem> regionalItemsByAreaSI(KZArea area);

    List<SelectItem> regionalItemsByAreaShortSI(KZArea area);

    List<KZCity> regionalItemsByArea(KZArea area);

    List<SelectItem> selectableItemsByAreaSI(KZArea area);

    List<SelectItem> selectableItemsByAreaShortSI(KZArea area);
}
