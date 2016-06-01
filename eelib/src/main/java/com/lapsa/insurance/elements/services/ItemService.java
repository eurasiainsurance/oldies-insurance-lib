package com.lapsa.insurance.elements.services;

import java.util.List;

import javax.faces.model.SelectItem;

public interface ItemService<T> {
    List<T> getAllItems();

    List<T> getSelectableItems();

    List<SelectItem> getAllItemsSI();

    List<SelectItem> getAllItemsShortSI();

    List<SelectItem> getSelectableItemsSI();

    List<SelectItem> getSelectableItemsShortSI();

    List<SelectItem> localizedSI(List<T> values);

    List<SelectItem> localizedShortSI(List<T> values);

    String localized(T value);

    String localizedShort(T value);

    String localizedKey(String key);
}
