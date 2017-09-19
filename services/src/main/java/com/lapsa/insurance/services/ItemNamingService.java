package com.lapsa.insurance.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.faces.model.SelectItem;

import com.lapsa.localization.LocalizationLanguage;

public interface ItemService<T> {

    // String

    String displayName(T value);

    String displayName(T value, Locale locale);

    default String displayName(T value, LocalizationLanguage lang) {
	return displayName(value, lang.getLocale());
    }

    default String displayNameFull(T value) {
	return displayName(value);
    }

    default String displayNameFull(T value, Locale locale) {
	return displayName(value, locale);
    }

    default String displayNameFull(T value, LocalizationLanguage lang) {
	return displayNameFull(value, lang.getLocale());
    }

    default String displayNameShort(T value) {
	return displayName(value);
    }

    default String displayNameShort(T value, Locale locale) {
	return displayName(value, locale);
    }

    default String displayNameShort(T value, LocalizationLanguage lang) {
	return displayNameShort(value, lang.getLocale());
    }

    // SelectItem

    default SelectItem displayNameSI(T item, Function<T, String> itemTitleSupplier) {
	return new SelectItem(item, itemTitleSupplier.apply(item));
    }

    default SelectItem displayNameSI(T item) {
	return displayNameSI(item, this::displayName);
    }

    default SelectItem displayNameFullSI(T item) {
	return displayNameSI(item, this::displayNameFull);
    }

    default SelectItem displayNameShortSI(T item) {
	return displayNameSI(item, this::displayNameShort);
    }

    // List<SelectItem>

    default List<SelectItem> displayNamesSI(List<T> list, Function<T, SelectItem> itemToSelectItemConverter) {
	return Optional.ofNullable(list) //
		.orElseGet(ArrayList::new) //
		.stream()
		.map(itemToSelectItemConverter) //
		.collect(Collectors.collectingAndThen(Collectors.toList(), //
			Collections::unmodifiableList));
    }

    default List<SelectItem> displayNamesSI(List<T> list) {
	return displayNamesSI(list, this::displayNameSI);
    }

    default List<SelectItem> displayNamesFullSI(List<T> list) {
	return displayNamesSI(list, this::displayNameFullSI);
    }

    default List<SelectItem> displayNamesShortSI(List<T> list) {
	return displayNamesSI(list, this::displayNameShortSI);
    }

}
