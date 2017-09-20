package com.lapsa.insurance;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.lapsa.international.localization.LocalizationLanguage;

public interface LocalizedElement {

    public static final String BUNDDLE_BASE_NAME = "ElementsLocalization";

    String name();

    default String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }

    default String displayName(Locale locale) {
	return CachedResourceBundles.byLocale(locale).flatMap(v -> {
	    try {
		return Optional.ofNullable(v.getString(String.format("%1$s.%2$s", this.getClass().getName(), name())));
	    } catch (NullPointerException | MissingResourceException | ClassCastException e) {
		return Optional.empty();
	    }
	}).orElseThrow(IllegalArgumentException::new);
    }

    default String displayName(LocalizationLanguage lang) {
	return displayName(lang.getLocale());
    }

    default String displayNameFull(Locale locale) {
	return CachedResourceBundles.byLocale(locale).flatMap(v -> {
	    try {
		return Optional.ofNullable(v.getString(String.format("%1$s.%2$s.full", this.getClass().getName(), name())));
	    } catch (NullPointerException | MissingResourceException | ClassCastException e) {
		return Optional.ofNullable(displayName(locale));
	    }
	}).orElseThrow(IllegalArgumentException::new);
    }

    default String displayNameFull(LocalizationLanguage lang) {
	return displayNameFull(lang.getLocale());
    }

    default String displayNameShort(Locale locale) {
	return CachedResourceBundles.byLocale(locale).flatMap(v -> {
	    try {
		return Optional.ofNullable(v.getString(String.format("%1$s.%2$s.short", this.getClass().getName(), name())));
	    } catch (Exception e) {
		return Optional.ofNullable(displayName(locale));
	    }
	}).orElseThrow(IllegalArgumentException::new);
    }

    default String displayNameShort(LocalizationLanguage lang) {
	return displayNameShort(lang.getLocale());
    }

    static class CachedResourceBundles {
	private static ConcurrentMap<Locale, ResourceBundle> rbs = new ConcurrentHashMap<>(5);

	public static Optional<ResourceBundle> byLocale(Locale locale) {
	    return Optional.ofNullable(rbs.computeIfAbsent(locale, x -> {
		try {
		    return ResourceBundle.getBundle(BUNDDLE_BASE_NAME, x);
		} catch (NullPointerException | MissingResourceException e) {
		    return null;
		}
	    }));
	}
    }

}
