package com.lapsa.insurance.services.domain.beans;

import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lapsa.insurance.domain.CompanyContactPhone;
import com.lapsa.insurance.services.domain.CompanyContactPhoneService;
import com.lapsa.insurance.services.elements.PhoneTypeService;

@Named("companyContactPhoneService")
@ApplicationScoped
public class DefaultCompanyContactPhoneService extends GenericDomainService<CompanyContactPhone>
	implements CompanyContactPhoneService {

    @Inject
    private PhoneTypeService phoneTypeService;

    @Override
    public String displayName(CompanyContactPhone value) {
	return generateDisplayName(phoneTypeService.displayNameShort(value.getPhoneType()),
		value.getPhone().getFormatted());
    }

    @Override
    public String displayName(CompanyContactPhone value, Locale locale) {
	return generateDisplayName(phoneTypeService.displayNameShort(value.getPhoneType(), locale),
		value.getPhone().getFormatted());
    }

    private String generateDisplayName(String phoneType, String phone) {
	StringBuffer sb = new StringBuffer();
	sb.append(phoneType);
	sb.append(": ");
	sb.append(phone);
	return sb.toString();
    }
}
