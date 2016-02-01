package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryDict;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;

public interface CountryServiceDAO extends GeneralServiceDAO<CountryDict, Long> {
    List<CountryDict> getAll();
}
