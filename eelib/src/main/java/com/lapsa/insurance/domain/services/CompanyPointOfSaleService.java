package com.lapsa.insurance.domain.services;

import java.util.List;

import com.lapsa.insurance.domain.CompanyPointOfSale;
import com.lapsa.kz.country.KZCity;

public interface CompanyPointOfSaleService {
    List<CompanyPointOfSale> pointOfSalesForPickup(KZCity city);

    List<CompanyPointOfSale> pointOfSalesForDelivery(KZCity city);

    List<KZCity> getCitiesForPickup();

    List<KZCity> getCitiesForDelivery();

    String localized(CompanyPointOfSale pointOfSale);
}
