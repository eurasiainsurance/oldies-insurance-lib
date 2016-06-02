package com.lapsa.insurance.elements.services.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.lapsa.insurance.elements.services.ItemService;

public abstract class BaseService<T> implements ItemService<T> {

    protected abstract String getMessageBundleBase();

    protected abstract String getMessageBundleVar();

    @Override
    public List<SelectItem> getAllItemsSI() {
	return localizedSI(getAllItems());
    }

    @Override
    public List<SelectItem> getAllItemsShortSI() {
	return localizedShortSI(getAllItems());
    }

    @Override
    public List<T> getSelectableItems() {
	return getAllItems(); // by default is the same that 'allItems'
    }

    @Override
    public List<SelectItem> getSelectableItemsSI() {
	return localizedSI(getSelectableItems());
    }

    @Override
    public List<SelectItem> getSelectableItemsShortSI() {
	return localizedShortSI(getSelectableItems());
    }

    public String localizedKey(String key) {
	FacesContext facesContext = FacesContext.getCurrentInstance();
	String bundleVar = getMessageBundleVar();
	ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, bundleVar);
	return localizedKey(key, bundle);
    }

    public String localizedKey(String key, Locale locale) {
	String bundleBase = getMessageBundleBase();
	ResourceBundle bundle = ResourceBundle.getBundle(bundleBase, locale);
	return localizedKey(key, bundle);
    }

    private String localizedKey(String key, ResourceBundle bundle) {
	if (key == null)
	    return null;
	try {
	    return bundle.getString(key);
	} catch (MissingResourceException e) {
	    return null;
	}
    }

    @Override
    public List<SelectItem> localizedSI(List<T> list) {
	List<SelectItem> result = new ArrayList<>();
	for (T item : list)
	    result.add(new SelectItem(item, localized(item)));
	return result;
    }

    @Override
    public List<SelectItem> localizedShortSI(List<T> list) {
	List<SelectItem> result = new ArrayList<>();
	for (T item : list)
	    result.add(new SelectItem(item, localizedShort(item)));
	return result;
    }
}
