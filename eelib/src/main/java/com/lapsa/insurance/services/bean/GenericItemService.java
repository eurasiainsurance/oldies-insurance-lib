package com.lapsa.insurance.services.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.model.SelectItem;

import com.lapsa.insurance.services.ItemService;

public abstract class GenericItemService<T> implements ItemService<T> {

    @Override
    public String displayNameShort(T value) {
	return displayName(value);
    }

    @Override
    public String displayNameShort(T value, Locale locale) {
	return displayName(value, locale);
    }

    @Override
    public List<SelectItem> displayNameSI(List<T> list) {
	List<SelectItem> result = new ArrayList<>();
	for (T item : list)
	    result.add(new SelectItem(item, displayName(item)));
	return result;
    }

    @Override
    public List<SelectItem> displayNameShortSI(List<T> list) {
	List<SelectItem> result = new ArrayList<>();
	for (T item : list)
	    result.add(new SelectItem(item, displayNameShort(item)));
	return result;
    }

}
