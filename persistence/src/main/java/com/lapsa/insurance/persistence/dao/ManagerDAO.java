package com.lapsa.insurance.persistence.dao;

import com.lapsa.insurance.domain.crm.Manager;

public interface ManagerDAO extends GeneralDAO<Manager, Integer> {
    Manager findByEmail(String email) throws PeristenceOperationFailed, EntityNotFound;
}
