package com.lapsa.insurance.services.elements;

import java.util.List;
import java.util.Locale;

import javax.faces.model.SelectItem;

import com.lapsa.insurance.services.ItemService;
import com.lapsa.localization.LocalizationLanguage;

public interface EnumService<T extends Enum<?>> extends ItemService<T> {

    List<T> getAllItems();

    List<T> getSelectableItems();

    List<SelectItem> getAllItemsSI();

    List<SelectItem> getAllItemsShortSI();

    List<SelectItem> getSelectableItemsSI();

    List<SelectItem> getSelectableItemsShortSI();

    String enumNameLocalized(T value);

    String enumNameLocalized(T value, Locale locale);

    String enumNameLocalized(T value, LocalizationLanguage lang);

    String enumNameLocalizedShort(T value);

    String enumNameLocalizedShort(T value, Locale locale);

    String enumNameLocalizedShort(T value, LocalizationLanguage lang);

    String enumNameLocalizedFull(T value);

    String enumNameLocalizedFull(T value, Locale locale);

    String enumNameLocalizedFull(T value, LocalizationLanguage lang);
}
