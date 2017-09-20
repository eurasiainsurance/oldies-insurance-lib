package com.lapsa.insurance.services.other;

import java.util.Locale;

import com.lapsa.international.localization.LocalizationLanguage;

public interface CurrentLanguageService {
    LocalizationLanguage getLanguage();
    void setLanguage(LocalizationLanguage language);
    Locale getLocale();
}
