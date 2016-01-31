package kz.theeurasia.esbdproxy.services;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.UserEntity;

public interface UserServiceDAO extends AbstractServiceDAO<UserEntity, Long> {
    List<UserEntity> getAll();
}
