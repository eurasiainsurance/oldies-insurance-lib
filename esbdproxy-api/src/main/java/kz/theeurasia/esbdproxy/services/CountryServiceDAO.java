package kz.theeurasia.esbdproxy.services;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.CountryDict;

public interface CountryServiceDAO extends AbstractServiceDAO<CountryDict, Long> {
    List<CountryDict> getAll();
}
