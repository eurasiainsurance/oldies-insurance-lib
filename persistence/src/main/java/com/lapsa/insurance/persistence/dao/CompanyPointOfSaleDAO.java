package com.lapsa.insurance.persistence.dao;

import java.util.List;

import com.lapsa.insurance.domain.CompanyPointOfSale;
import com.lapsa.kz.country.KZCity;

public interface CompanyPointOfSaleDAO extends GeneralDAO<CompanyPointOfSale, Integer> {

    List<CompanyPointOfSale> findWithPickupAvailable() throws PeristenceOperationFailed;

    List<CompanyPointOfSale> findWithPickupAvailable(KZCity pickupCity) throws PeristenceOperationFailed;

    List<KZCity> findCitiesWithPickupAvailable() throws PeristenceOperationFailed;

    List<CompanyPointOfSale> findWithDeliveryAvailable() throws PeristenceOperationFailed;

    List<CompanyPointOfSale> findWithDeliveryAvailable(KZCity deliveryCity) throws PeristenceOperationFailed;

    List<KZCity> findCitiesWithDeliveryAvailable() throws PeristenceOperationFailed;

    List<CompanyPointOfSale> findAllOwnOffices() throws PeristenceOperationFailed;

}
