package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.general.UserEntity;
import kz.theeurasia.esbdproxy.services.AbstractServiceDAO;

public interface UserServiceDAO extends AbstractServiceDAO<UserEntity, Long> {
    List<UserEntity> getAll();
}
