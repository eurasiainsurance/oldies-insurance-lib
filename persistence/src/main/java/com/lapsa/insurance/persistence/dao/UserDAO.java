package com.lapsa.insurance.persistence.dao;

import com.lapsa.insurance.domain.crm.User;

public interface UserDAO extends GeneralDAO<User, Integer> {
    User findByEmail(String email) throws PeristenceOperationFailed, EntityNotFound;
}
