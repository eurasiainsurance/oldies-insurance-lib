package com.lapsa.insurance.services;

import java.util.List;

import javax.faces.model.SelectItem;

public interface EnumListingNamingService<T extends Enum<?>> extends ItemNamingService<T> {

    List<T> getAllItems();

    List<SelectItem> getAllItemsShortSI();

    List<SelectItem> getAllItemsSI();

    List<T> getSelectableItems();

    List<SelectItem> getSelectableItemsShortSI();

    List<SelectItem> getSelectableItemsSI();
}
