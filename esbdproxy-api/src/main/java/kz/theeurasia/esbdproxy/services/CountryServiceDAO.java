package kz.theeurasia.esbdproxy.services;

import java.util.List;

import kz.theeurasia.esbdproxy.dict.CountryDict;

public interface CountryServiceDAO extends EntityServiceDAO<CountryDict, Long> {
    List<CountryDict> getAll();
}
