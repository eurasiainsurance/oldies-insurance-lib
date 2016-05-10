package kz.theeurasia.policy.services;

import com.lapsa.localization.LocalizationLanguage;

public interface CurrentLanguageService {
    LocalizationLanguage getLanguage();
    void setLanguage(LocalizationLanguage language);
}
