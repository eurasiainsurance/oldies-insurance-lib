package com.lapsa.insurance.services;

import java.util.List;
import java.util.Locale;

import javax.faces.model.SelectItem;

import com.lapsa.international.localization.LocalizationLanguage;

public interface EnumListingNamingService<T extends Enum<?>> extends ItemNamingService<T> {

    String enumNameLocalized(T value);

    String enumNameLocalized(T value, Locale locale);

    String enumNameLocalized(T value, LocalizationLanguage lang);

    String enumNameLocalizedFull(T value);

    String enumNameLocalizedFull(T value, Locale locale);

    String enumNameLocalizedFull(T value, LocalizationLanguage lang);

    String enumNameLocalizedShort(T value);

    String enumNameLocalizedShort(T value, Locale locale);

    String enumNameLocalizedShort(T value, LocalizationLanguage lang);

    List<T> getAllItems();

    List<SelectItem> getAllItemsShortSI();

    List<SelectItem> getAllItemsSI();

    List<T> getSelectableItems();

    List<SelectItem> getSelectableItemsShortSI();

    List<SelectItem> getSelectableItemsSI();
}
