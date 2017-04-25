package com.lapsa.insurance.faces.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.omnifaces.converter.SelectItemsConverter;

import com.lapsa.insurance.domain.crm.User;

@FacesConverter(forClass = User.class)
public class UserSelectItemConverter extends SelectItemsConverter {

    @Override
    public String getAsString(FacesContext context, UIComponent component,
	    Object value) {
	Integer id = (value instanceof User) ? ((User) value).getId() : null;
	return (id != null) ? String.valueOf(id) : null;
    }

}
