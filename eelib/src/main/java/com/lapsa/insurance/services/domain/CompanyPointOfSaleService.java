package com.lapsa.insurance.services.domain;

import java.util.List;

import javax.faces.model.SelectItem;

import com.lapsa.insurance.domain.CompanyPointOfSale;
import com.lapsa.kz.country.KZCity;

public interface CompanyPointOfSaleService extends DomainService<CompanyPointOfSale> {
    List<CompanyPointOfSale> pointOfSalesForPickup(KZCity city);

    List<SelectItem> pointOfSalesForPickupSI(KZCity city);

    List<CompanyPointOfSale> pointOfSalesForDelivery(KZCity city);

    List<SelectItem> pointOfSalesForDeliverySI(KZCity city);

    // TODO подумать куда это вынести
    List<KZCity> getCitiesForPickup();

    List<KZCity> getCitiesForDelivery();
}
