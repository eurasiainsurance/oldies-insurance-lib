package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryDict;
import kz.theeurasia.esbdproxy.services.AbstractServiceDAO;

public interface CountryServiceDAO extends AbstractServiceDAO<CountryDict, Long> {
    List<CountryDict> getAll();
}
