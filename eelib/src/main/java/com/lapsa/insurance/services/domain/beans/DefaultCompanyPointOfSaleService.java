package com.lapsa.insurance.services.domain.beans;

import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.lapsa.insurance.domain.CompanyPointOfSale;
import com.lapsa.insurance.persistence.dao.CompanyPointOfSaleDAO;
import com.lapsa.insurance.persistence.dao.PeristenceOperationFailed;
import com.lapsa.insurance.services.domain.CompanyPointOfSaleService;
import com.lapsa.insurance.services.domain.PostAddressService;
import com.lapsa.kz.country.KZCity;
import com.lapsa.localization.LocalizationLanguage;

@Named("companyPointOfSaleService")
@ApplicationScoped
public class DefaultCompanyPointOfSaleService extends GenericDomainService<CompanyPointOfSale>
	implements CompanyPointOfSaleService {

    @EJB
    private CompanyPointOfSaleDAO companyPointOfSaleDAO;

    @Inject
    private PostAddressService postAddressService;

    @Override
    public List<CompanyPointOfSale> pointOfSalesForPickup(KZCity city) {
	try {
	    if (city == null)
		return companyPointOfSaleDAO.findWithPickupAvailable();
	    else
		return companyPointOfSaleDAO.findWithPickupAvailable(city);
	} catch (PeristenceOperationFailed e) {
	    throw new RuntimeException(e);
	}
    }

    @Override
    public List<KZCity> getCitiesForPickup() {
	try {
	    return companyPointOfSaleDAO.findCitiesWithPickupAvailable();
	} catch (PeristenceOperationFailed e) {
	    throw new RuntimeException(e);
	}
    }

    @Override
    public List<CompanyPointOfSale> pointOfSalesForDelivery(KZCity city) {
	try {
	    if (city == null)
		return companyPointOfSaleDAO.findWithDeliveryAvailable();
	    else
		return companyPointOfSaleDAO.findWithDeliveryAvailable(city);
	} catch (PeristenceOperationFailed e) {
	    throw new RuntimeException(e);
	}
    }

    @Override
    public List<KZCity> getCitiesForDelivery() {
	try {
	    return companyPointOfSaleDAO.findCitiesWithDeliveryAvailable();
	} catch (PeristenceOperationFailed e) {
	    throw new RuntimeException(e);
	}
    }

    private String generateDisplayNameFull(String name, String address) {
	StringBuffer sb = new StringBuffer();
	if (name != null)
	    sb.append(name + ", ");
	if (address != null)
	    sb.append(address);
	return sb.toString();
    }

    @Override
    public String displayName(CompanyPointOfSale pointOfSale) {
	return generateName(pointOfSale);
    }

    @Override
    public String displayName(CompanyPointOfSale pointOfSale, Locale locale) {
	return generateName(pointOfSale, locale);
    }

    private String generateName(CompanyPointOfSale pointOfSale, Locale locale) {
	LocalizationLanguage lang = LocalizationLanguage.byTag(locale.getLanguage());
	if (lang != null && pointOfSale.getNameLocalization().containsKey(lang))
	    return pointOfSale.getNameLocalization().get(lang);
	return pointOfSale.getName();
    }

    private String generateName(CompanyPointOfSale pointOfSale) {
	FacesContext facesContext = FacesContext.getCurrentInstance();
	Locale locale = facesContext.getViewRoot().getLocale();
	return generateName(pointOfSale, locale);
    }

    @Override
    public String displayNameFull(CompanyPointOfSale pointOfSale) {
	String address = postAddressService.displayName(pointOfSale.getAddress());
	String name = generateName(pointOfSale);
	return generateDisplayNameFull(name, address);
    }

    @Override
    public String displayNameFull(CompanyPointOfSale pointOfSale, Locale locale) {
	String address = postAddressService.displayName(pointOfSale.getAddress(), locale);
	String name = generateName(pointOfSale, locale);
	return generateDisplayNameFull(name, address);
    }

    @Override
    public List<SelectItem> pointOfSalesForPickupSI(KZCity city) {
	return displayNamesSI(pointOfSalesForPickup(city));
    }

    @Override
    public List<SelectItem> pointOfSalesForPickupShortSI(KZCity city) {
	return displayNamesShortSI(pointOfSalesForPickup(city));
    }

    @Override
    public List<SelectItem> pointOfSalesForDeliverySI(KZCity city) {
	return displayNamesSI(pointOfSalesForDelivery(city));
    }

    @Override
    public List<SelectItem> pointOfSalesForDeliveryShortSI(KZCity city) {
	return displayNamesShortSI(pointOfSalesForDelivery(city));
    }
}
