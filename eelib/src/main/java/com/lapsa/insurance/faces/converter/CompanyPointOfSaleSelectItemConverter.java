package com.lapsa.insurance.faces.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import org.omnifaces.converter.SelectItemsConverter;

import com.lapsa.insurance.domain.CompanyPointOfSale;

@FacesConverter(forClass = CompanyPointOfSale.class)
public class CompanyPointOfSaleSelectItemConverter extends SelectItemsConverter {
    @Override
    public String getAsString(FacesContext context, UIComponent component,
	    Object value) {
	Integer id = (value instanceof CompanyPointOfSale) ? ((CompanyPointOfSale) value).getId() : null;
	return (id != null) ? String.valueOf(id) : null;
    }
}
