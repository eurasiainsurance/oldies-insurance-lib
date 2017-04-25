package com.lapsa.insurance.dao;

import java.util.List;

import com.lapsa.insurance.domain.crm.User;

public interface UserDAO extends GeneralDAO<User, Integer> {
    User findByLogin(String login) throws PeristenceOperationFailed, EntityNotFound;

    List<User> findAll() throws PeristenceOperationFailed;

    List<User> findEnabled() throws PeristenceOperationFailed;
}
