package kz.theeurasia.policy.converter;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryDict;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.CountryServiceDAO;

@ManagedBean(name = "countryToTextConverter")
@RequestScoped
public class CountryToTextConverter implements Converter {

    @EJB
    private CountryServiceDAO countryService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
	try {
	    CountryDict res = countryService.getOneByName(value);
	    return res;
	} catch (NotFound e) {
	    // TODO add localization
	    throw new ConverterException(new FacesMessage("Invalid country name"));
	}
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
	if (value instanceof CountryDict) {
	    CountryDict cd = (CountryDict) value;
	    return cd.getRusname();
	}
	return null;
    }

}
