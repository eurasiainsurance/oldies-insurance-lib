package kz.theeurasia.policy.services;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LocaleService {
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
