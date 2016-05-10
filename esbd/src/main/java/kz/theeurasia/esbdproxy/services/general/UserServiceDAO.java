package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.general.UserEntity;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;

public interface UserServiceDAO extends GeneralServiceDAO<UserEntity, Long> {
    List<UserEntity> getAll();
}
