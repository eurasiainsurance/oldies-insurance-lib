package com.lapsa.insurance.elements.services;

import com.lapsa.localization.LocalizationLanguage;

public interface CurrentLanguageService {
    LocalizationLanguage getLanguage();
    void setLanguage(LocalizationLanguage language);
}
