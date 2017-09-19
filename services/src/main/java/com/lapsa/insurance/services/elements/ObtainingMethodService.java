package com.lapsa.insurance.services.elements;

import java.util.List;

import javax.faces.model.SelectItem;

import com.lapsa.insurance.elements.ObtainingMethod;
import com.lapsa.insurance.services.EnumListingNamingService;

public interface ObtainingMethodService extends EnumListingNamingService<ObtainingMethod> {

    List<ObtainingMethod> getValueItems();

    List<SelectItem> getValueItemsSI();

    List<SelectItem> getValueItemsShortSI();

    List<SelectItem> getValueItemsFullSI();
}
