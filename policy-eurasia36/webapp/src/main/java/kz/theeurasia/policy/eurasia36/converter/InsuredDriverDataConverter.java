package kz.theeurasia.policy.eurasia36.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import kz.theeurasia.policy.domain.InsuredDriverData;
import kz.theeurasia.policy.eurasia36.bean.OSGPOVTSView;

@FacesConverter(forClass = InsuredDriverData.class)
public class InsuredDriverDataConverter implements Converter {

    @Inject
    private OSGPOVTSView osgpovtsView;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
	for (InsuredDriverData driver : osgpovtsView.getPolicy().getInsuredDrivers()) {
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
