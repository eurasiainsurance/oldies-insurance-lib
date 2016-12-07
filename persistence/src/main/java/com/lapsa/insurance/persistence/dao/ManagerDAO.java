package com.lapsa.insurance.persistence.dao;

import java.util.List;

import com.lapsa.insurance.domain.crm.Manager;

public interface ManagerDAO extends GeneralDAO<Manager, Integer> {
    List<Manager> findByEmail(String email) throws PeristenceOperationFailed;
}
