package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.general.CityEntity;
import kz.theeurasia.esbdproxy.services.AbstractServiceDAO;

public interface CityServiceDAO extends AbstractServiceDAO<CityEntity, Long> {
    List<CityEntity> getAll();
}
