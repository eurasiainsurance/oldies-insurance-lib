package com.lapsa.insurance.services;

import java.util.List;
import java.util.Locale;

import javax.faces.model.SelectItem;

import com.lapsa.localization.LocalizationLanguage;

public interface ItemService<T> {

    String displayName(T value);

    String displayName(T value, Locale locale);

    String displayName(T value, LocalizationLanguage lang);

    String displayNameShort(T value);

    String displayNameShort(T value, Locale locale);

    String displayNameShort(T value, LocalizationLanguage lang);

    String displayNameFull(T value);

    String displayNameFull(T value, Locale locale);

    String displayNameFull(T value, LocalizationLanguage lang);

    List<SelectItem> displayNamesShortSI(List<T> list);

    List<SelectItem> displayNamesFullSI(List<T> list);

    List<SelectItem> displayNamesSI(List<T> list);

}
