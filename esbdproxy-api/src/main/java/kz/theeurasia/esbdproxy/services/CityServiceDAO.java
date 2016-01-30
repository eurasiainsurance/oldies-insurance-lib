package kz.theeurasia.esbdproxy.services;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.entities.CityEntity;

public interface CityServiceDAO extends AbstractServiceDAO<CityEntity, Long>{
    List<CityEntity> getAll();
}
