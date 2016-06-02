package com.lapsa.insurance.domain.services.beans;

import java.util.List;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.lapsa.insurance.domain.CompanyPointOfSale;
import com.lapsa.insurance.domain.services.CompanyPointOfSaleService;
import com.lapsa.insurance.elements.services.KZCityService;
import com.lapsa.insurance.persistence.dao.CompanyPointOfSaleDAO;
import com.lapsa.kz.country.KZCity;

@Named("companyPointOfSaleService")
@ApplicationScoped
public class DefaultCompanyPointOfSaleService extends GenericDomainService<CompanyPointOfSale>
	implements CompanyPointOfSaleService {

    @Inject
    private CompanyPointOfSaleDAO companyPointOfSaleDAO;

    @Inject
    private KZCityService kzCityService;

    @Override
    public List<CompanyPointOfSale> pointOfSalesForPickup(KZCity city) {
	if (city == null)
	    return companyPointOfSaleDAO.findWithPickupAvailable();
	else
	    return companyPointOfSaleDAO.findWithPickupAvailable(city);
    }

    @Override
    public List<KZCity> getCitiesForPickup() {
	return companyPointOfSaleDAO.findCitiesWithPickupAvailable();
    }

    @Override
    public List<CompanyPointOfSale> pointOfSalesForDelivery(KZCity city) {
	if (city == null)
	    return companyPointOfSaleDAO.findWithDeliveryAvailable();
	else
	    return companyPointOfSaleDAO.findWithDeliveryAvailable(city);
    }

    @Override
    public List<KZCity> getCitiesForDelivery() {
	return companyPointOfSaleDAO.findCitiesWithDeliveryAvailable();
    }

    @Override
    public String displayName(CompanyPointOfSale pointOfSale) {
	return generateDisplayName(kzCityService.displayName(pointOfSale.getCity()), pointOfSale.getAddress());
    }

    @Override
    public String displayName(CompanyPointOfSale pointOfSale, Locale locale) {
	return generateDisplayName(kzCityService.displayName(pointOfSale.getCity(), locale), pointOfSale.getAddress());
    }

    @Override
    public List<SelectItem> pointOfSalesForPickupSI(KZCity city) {
	return displayNameSI(pointOfSalesForPickup(city));
    }

    @Override
    public List<SelectItem> pointOfSalesForDeliverySI(KZCity city) {
	return displayNameSI(pointOfSalesForDelivery(city));
    }

    private String generateDisplayName(String city, String address) {
	StringBuffer sb = new StringBuffer();
	sb.append(city);
	sb.append(", ");
	sb.append(address);
	return sb.toString();
    }
}
