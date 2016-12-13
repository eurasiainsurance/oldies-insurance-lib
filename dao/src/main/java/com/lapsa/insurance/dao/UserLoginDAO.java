package com.lapsa.insurance.dao;

import com.lapsa.insurance.domain.crm.UserLogin;

public interface UserLoginDAO extends GeneralDAO<UserLogin, Integer> {
    UserLogin findByName(String name) throws PeristenceOperationFailed, EntityNotFound;
}
