package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryDict;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

public interface CountryServiceDAO extends GeneralServiceDAO<CountryDict, Long> {
    List<CountryDict> getAll();
    List<CountryDict> getBySearchPattern(String pattern);
    CountryDict getOneByName(String value) throws NotFound;
    List<CountryDict> getSelectable();
}
