package com.lapsa.insurance.services.domain.beans;

import java.util.List;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.lapsa.insurance.domain.CompanyPointOfSale;
import com.lapsa.insurance.persistence.dao.CompanyPointOfSaleDAO;
import com.lapsa.insurance.services.domain.CompanyPointOfSaleService;
import com.lapsa.insurance.services.domain.PostAddressService;
import com.lapsa.kz.country.KZCity;

@Named("companyPointOfSaleService")
@ApplicationScoped
public class DefaultCompanyPointOfSaleService extends GenericDomainService<CompanyPointOfSale>
	implements CompanyPointOfSaleService {

    @Inject
    private CompanyPointOfSaleDAO companyPointOfSaleDAO;

    @Inject
    private PostAddressService postAddressService;

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
	StringBuffer sb = new StringBuffer();
	if (pointOfSale.getName() != null)
	    sb.append(pointOfSale.getName() + ", ");
	if (pointOfSale.getAddress() != null)
	    sb.append(postAddressService.displayName(pointOfSale.getAddress()));
	return sb.toString();
    }

    @Override
    public String displayName(CompanyPointOfSale pointOfSale, Locale locale) {
	return displayName(pointOfSale);
    }

    @Override
    public String displayNameShort(CompanyPointOfSale pointOfSale) {
	return pointOfSale.getName();
    }

    @Override
    public String displayNameShort(CompanyPointOfSale pointOfSale, Locale locale) {
	return pointOfSale.getName();
    }

    @Override
    public List<SelectItem> pointOfSalesForPickupSI(KZCity city) {
	return displayNameSI(pointOfSalesForPickup(city));
    }

    @Override
    public List<SelectItem> pointOfSalesForPickupShortSI(KZCity city) {
	return displayNameShortSI(pointOfSalesForPickup(city));
    }

    @Override
    public List<SelectItem> pointOfSalesForDeliverySI(KZCity city) {
	return displayNameSI(pointOfSalesForDelivery(city));
    }

    @Override
    public List<SelectItem> pointOfSalesForDeliveryShortSI(KZCity city) {
	return displayNameShortSI(pointOfSalesForDelivery(city));
    }
}
