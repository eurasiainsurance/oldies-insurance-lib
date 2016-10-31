package com.lapsa.insurance.services.domain;

import java.util.List;
import java.util.Locale;

import javax.faces.model.SelectItem;

import com.lapsa.insurance.domain.CompanyPointOfSale;
import com.lapsa.kz.country.KZCity;
import com.lapsa.localization.LocalizationLanguage;

public interface CompanyPointOfSaleService extends DomainService<CompanyPointOfSale> {
    List<CompanyPointOfSale> pointOfSalesForPickup(KZCity city);

    List<SelectItem> pointOfSalesForPickupSI(KZCity city);

    List<SelectItem> pointOfSalesForPickupShortSI(KZCity city);

    List<CompanyPointOfSale> pointOfSalesForDelivery(KZCity city);

    List<SelectItem> pointOfSalesForDeliverySI(KZCity city);

    List<SelectItem> pointOfSalesForDeliveryShortSI(KZCity city);

    // TODO подумать куда это вынести
    List<KZCity> getCitiesForPickup();

    List<KZCity> getCitiesForDelivery();

    String displayAddress(CompanyPointOfSale pointOfSale);

    String displayAddress(CompanyPointOfSale pointOfSale, Locale locale);
    
    String displayAddress(CompanyPointOfSale pointOfSale, LocalizationLanguage lang);

    List<SelectItem> displayAddressSI(List<CompanyPointOfSale> list);

    String displayAddressShort(CompanyPointOfSale pointOfSale);

    String displayAddressShort(CompanyPointOfSale pointOfSale, Locale locale);

    String displayAddressShort(CompanyPointOfSale pointOfSale, LocalizationLanguage lang);

    List<SelectItem> displayAddressShortSI(List<CompanyPointOfSale> list);
}
