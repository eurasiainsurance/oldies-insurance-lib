package com.lapsa.insurance.elements.services.beans;

import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.lapsa.insurance.elements.services.EnumService;

public abstract class GenericEnumService<T extends Enum<T>> extends GenericItemService<T> implements EnumService<T> {

    protected abstract String getMessageBundleBase();

    protected abstract String getMessageBundleVar();

    @Override
    public List<SelectItem> getAllItemsSI() {
	return displayNameSI(getAllItems());
    }

    @Override
    public List<SelectItem> getAllItemsShortSI() {
	return displayNameShortSI(getAllItems());
    }

    @Override
    public List<T> getSelectableItems() {
	return getAllItems(); // by default is the same that 'allItems'
    }

    @Override
    public List<SelectItem> getSelectableItemsSI() {
	return displayNameSI(getSelectableItems());
    }

    @Override
    public List<SelectItem> getSelectableItemsShortSI() {
	return displayNameShortSI(getSelectableItems());
    }

    @Override
    public String displayName(T value) {
	// default - enumName
	return enumNameLocalized(value);
    }

    @Override
    public String displayNameShort(T value) {
	// default - enumNameShort
	return enumNameLocalizedShort(value);
    }

    @Override
    public String displayName(T value, Locale locale) {
	// default - enumName
	return enumNameLocalized(value, locale);
    }

    @Override
    public String displayNameShort(T value, Locale locale) {
	// default - enumNameShort
	return enumNameLocalizedShort(value, locale);
    }

    @Override
    public String enumNameLocalized(T value) {
	if (value == null)
	    return null;
	return localizationByKey(String.format("%1$s.%2$s", value.getClass().getName(), value.name()));
    }

    @Override
    public String enumNameLocalized(T value, Locale locale) {
	if (value == null)
	    return null;
	return localizationByKey(String.format("%1$s.%2$s", value.getClass().getName(), value.name()), locale);
    }

    @Override
    public String enumNameLocalizedShort(T value) {
	if (value == null)
	    return null;
	String ret = localizationByKey(String.format("%1$s.%2$s.short", value.getClass().getName(), value.name()));
	if (ret != null)
	    return ret;
	return enumNameLocalized(value);
    }

    @Override
    public String enumNameLocalizedShort(T value, Locale locale) {
	if (value == null)
	    return null;
	String ret = localizationByKey(String.format("%1$s.%2$s.short", value.getClass().getName(), value.name()),
		locale);
	if (ret != null)
	    return ret;
	return enumNameLocalized(value, locale);
    }

    protected String localizationByKey(String key) {
	FacesContext facesContext = FacesContext.getCurrentInstance();
	String bundleVar = getMessageBundleVar();
	ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, bundleVar);
	return localizationByKey(key, bundle);
    }

    protected String localizationByKey(String key, Locale locale) {
	String bundleBase = getMessageBundleBase();
	ResourceBundle bundle = ResourceBundle.getBundle(bundleBase, locale);
	return localizationByKey(key, bundle);
    }

    protected String localizationByKey(String key, ResourceBundle bundle) {
	if (key == null)
	    return null;
	try {
	    return bundle.getString(key);
	} catch (MissingResourceException e) {
	    return null;
	}
    }
}
