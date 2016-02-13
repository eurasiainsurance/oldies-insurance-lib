package kz.theeurasia.policy.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import kz.theeurasia.policy.domain.InsuredDriverData;
import kz.theeurasia.policy.domain.PolicyRequestData;

@ManagedBean
@ViewScoped
@FacesConverter(forClass = InsuredDriverData.class)
public class InsuredDriverDataConverter implements Converter {

    @ManagedProperty("#{osgpovtsView.policy}")
    private PolicyRequestData policy;

    public void setPolicy(PolicyRequestData policy) {
	this.policy = policy;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
	for (InsuredDriverData driver : policy.getInsuredDrivers()) {
	    if (driver.getSafeId().equals(value))
		return driver;
	}

	throw new ConverterException("Not found with ID " + value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
	if (value instanceof InsuredDriverData) {
	    InsuredDriverData cd = (InsuredDriverData) value;
	    return cd.getSafeId();
	}
	throw new ConverterException("Is not instance of " + InsuredDriverData.class.getCanonicalName());
    }

}
