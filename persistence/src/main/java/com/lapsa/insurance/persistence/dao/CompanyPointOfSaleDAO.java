package com.lapsa.insurance.persistence.dao;

import java.util.List;

import com.lapsa.insurance.domain.CompanyPointOfSale;
import com.lapsa.kz.country.KZCity;

public interface CompanyPointOfSaleDAO extends DAO<CompanyPointOfSale, Integer> {

    List<CompanyPointOfSale> findWithPickupAvailable();

    List<CompanyPointOfSale> findWithPickupAvailable(KZCity pickupCity);

    List<KZCity> findCitiesWithPickupAvailable();

    List<CompanyPointOfSale> findWithDeliveryAvailable();

    List<CompanyPointOfSale> findWithDeliveryAvailable(KZCity deliveryCity);

    List<KZCity> findCitiesWithDeliveryAvailable();

    List<CompanyPointOfSale> findAllOwnOffices();

}
