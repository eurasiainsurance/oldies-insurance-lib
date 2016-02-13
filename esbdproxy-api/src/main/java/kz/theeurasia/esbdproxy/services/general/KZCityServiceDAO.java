package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.general.KZCityDict;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;

public interface KZCityServiceDAO extends GeneralServiceDAO<KZCityDict, Long> {
    List<KZCityDict> getAll();
    List<KZCityDict> getBySearchPattern(String pattern);
    List<KZCityDict> getSelectable();
}
