package com.lapsa.insurance.esbd.services.general;

import java.util.List;

import com.lapsa.insurance.esbd.services.GeneralServiceDAO;

import kz.theeurasia.esbdproxy.domain.entities.general.UserEntity;

public interface UserServiceDAO extends GeneralServiceDAO<UserEntity, Long> {
    List<UserEntity> getAll();
}
