package com.lapsa.insurance.elements.services;

import java.util.List;

import javax.faces.model.SelectItem;

public interface ItemService<T> {
    List<T> getAllItems();

    List<T> getSelectableItems();

    List<SelectItem> getAllItemsSI();

    List<SelectItem> getSelectableItemsSI();

    String localized(T value);

    String localizedKey(String key);
}
