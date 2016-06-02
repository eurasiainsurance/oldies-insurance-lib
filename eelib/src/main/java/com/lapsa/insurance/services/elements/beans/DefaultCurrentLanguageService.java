package com.lapsa.insurance.services.elements.beans;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.lapsa.insurance.services.elements.CurrentLanguageService;
import com.lapsa.localization.LocalizationLanguage;

@Named("currentLanguageService")
@SessionScoped
public class DefaultCurrentLanguageService implements CurrentLanguageService, Serializable {

    private static final long serialVersionUID = -1456158779863948288L;

    private LocalizationLanguage language;

    @PostConstruct
    public void init() {
	// try to set language defined in user agent
	language = getByLocale(FacesContext.getCurrentInstance().getExternalContext().getRequestLocale());
	// if fails trying to set language defined in application as
	// default
	if (language == null)
	    language = getByLocale(FacesContext.getCurrentInstance().getApplication().getDefaultLocale());
	// if fails seting hardcoded language - RUSSIAN
	if (language == null)
	    language = LocalizationLanguage.RUSSIAN;
    }

    @Override
    public Locale getLocale() {
	return Locale.forLanguageTag(language.getTag());
    }

    @Override
    public LocalizationLanguage getLanguage() {
	return language;
    }

    @Override
    public void setLanguage(LocalizationLanguage language) {
	this.language = language;
	Locale locale = Locale.forLanguageTag(language.getTag());
	FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

    private LocalizationLanguage getByLocale(Locale locale) {
	return LocalizationLanguage.byTag(locale.getLanguage());
    }
}
