package com.lapsa.insurance.services.domain.beans;

import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
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

    @EJB
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
	return pointOfSale.getName();
    }

    @Override
    public String displayName(CompanyPointOfSale pointOfSale, Locale locale) {
	return pointOfSale.getName();
    }

    @Override
    public String displayNameFull(CompanyPointOfSale pointOfSale) {
	String address = postAddressService.displayName(pointOfSale.getAddress());
	return generateDisplayNameFull(pointOfSale.getName(), address);
    }

    @Override
    public String displayNameFull(CompanyPointOfSale pointOfSale, Locale locale) {
	String address = postAddressService.displayName(pointOfSale.getAddress(), locale);
	return generateDisplayNameFull(pointOfSale.getName(), address);
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
