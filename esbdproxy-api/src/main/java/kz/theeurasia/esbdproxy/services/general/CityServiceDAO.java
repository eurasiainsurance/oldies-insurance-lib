package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.general.CityEntity;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;

public interface CityServiceDAO extends GeneralServiceDAO<CityEntity, Long> {
    List<CityEntity> getAll();
    List<CityEntity> getBySearchPattern(String pattern);
}
