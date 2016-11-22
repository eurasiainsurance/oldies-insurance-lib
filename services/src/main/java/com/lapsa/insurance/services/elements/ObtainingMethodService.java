package com.lapsa.insurance.services.elements;

import java.util.List;

import javax.faces.model.SelectItem;

import com.lapsa.insurance.elements.ObtainingMethod;
import com.lapsa.insurance.services.EnumService;

public interface ObtainingMethodService extends EnumService<ObtainingMethod> {
    List<ObtainingMethod> getValueItems();

    List<SelectItem> getValueItemsSI();

    List<SelectItem> getValueItemsShortSI();

    List<SelectItem> getValueItemsFullSI();

    List<ObtainingMethod> getNonValueItems();

    List<SelectItem> getNonValueItemsSI();

    List<SelectItem> getNonValueItemsShortSI();

    List<SelectItem> getNonValueItemsFullSI();
}
