package com.lapsa.policy.faces.converter;

import java.util.Locale;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "maskedVINCodeConverter")
public class MaskedVINCodeConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
	if (value == null)
	    return null;
	return value.toUpperCase(Locale.ENGLISH);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
	if (value == null)
	    return null;
	return value.toString();
    }

}
