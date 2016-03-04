package kz.theeurasia.policy.services;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class LocaleService implements Serializable {

    private static final long serialVersionUID = 1L;

    private Locale currentLocale;

    @PostConstruct
    public void init() {
	currentLocale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
    }

    public Locale getLocale() {
	return currentLocale;
    }

    public void setLocale(Locale locale) {
	this.currentLocale = locale;
    }
}
