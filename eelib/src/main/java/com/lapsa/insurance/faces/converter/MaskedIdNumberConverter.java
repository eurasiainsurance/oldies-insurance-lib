package com.lapsa.insurance.faces.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "maskedIdNumberConverter")
public class MaskedIdNumberConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
	if (value == null)
	    return null;
	return value.replaceAll("\\D", "");
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
	if (value == null)
	    return null;
	return value.toString();
    }

}
