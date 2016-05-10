package kz.theeurasia.policy.services.inject;

import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.lapsa.localization.LocalizationLanguage;

import kz.theeurasia.policy.services.CurrentLanguageService;

@Named("currentLanguageService")
@ApplicationScoped
public class DefaultCurrentLanguageService implements CurrentLanguageService {

    @Override
    public LocalizationLanguage getLanguage() {
	Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	LocalizationLanguage ret = LocalizationLanguage.byTag(locale.getLanguage());
	return ret;
    }

    @Override
    public void setLanguage(LocalizationLanguage language) {
	Locale locale = Locale.forLanguageTag(language.getTag());
	FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
}
