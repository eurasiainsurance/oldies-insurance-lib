
package kz.theeurasia.policy.services.inject;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.localization.LocalizationLanguage;

import kz.theeurasia.policy.services.LocalizationLanguageService;

@Named("localizationLanguageService")
@ApplicationScoped
public class DefaultLocalizationLanguageService extends EnumService<LocalizationLanguage> implements LocalizationLanguageService {

    @Override
    public List<LocalizationLanguage> getAllItems() {
	return CollectionUtils.toList(LocalizationLanguage.values());
    }

    @Override
    protected String getMessageBundleBase() {
	return LocalizationLanguage.BUNDLE_BASENAME;
    }

    @Override
    protected String getMessageBundleName() {
	return LocalizationLanguage.BUNDLE_VAR;
    }

}
