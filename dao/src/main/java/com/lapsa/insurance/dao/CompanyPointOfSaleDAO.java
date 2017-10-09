package com.lapsa.insurance.dao;

import java.util.List;

import com.lapsa.insurance.domain.CompanyPointOfSale;

public interface CompanyPointOfSaleDAO extends GeneralDAO<CompanyPointOfSale, Integer> {
    List<CompanyPointOfSale> findAll() throws PeristenceOperationFailed;
}
