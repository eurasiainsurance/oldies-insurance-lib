package com.lapsa.insurance.elements.services.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.lapsa.insurance.elements.services.ItemService;

public abstract class GenericItemService<T> implements ItemService<T> {

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
