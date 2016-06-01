package com.lapsa.insurance.domain.services.beans;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lapsa.insurance.domain.CompanyPointOfSale;
import com.lapsa.insurance.domain.services.CompanyPointOfSaleService;
import com.lapsa.insurance.elements.services.KZCityService;
import com.lapsa.insurance.persistence.dao.CompanyPointOfSaleDAO;
import com.lapsa.kz.country.KZCity;

@Named("companyPointOfSaleService")
@ApplicationScoped
public class DefaultCompanyPointOfSaleService implements CompanyPointOfSaleService {

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
    public String localized(CompanyPointOfSale pointOfSale) {
	StringBuffer sb = new StringBuffer(kzCityService.localized(pointOfSale.getCity()));
	sb.append(", ");
	sb.append(pointOfSale.getAddress());
	return sb.toString();
    }

}
