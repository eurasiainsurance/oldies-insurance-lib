package kz.theeurasia.esbdproxy.services;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.CountryRegionDict;

public interface CountryRegionServiceDAO extends AbstractServiceDAO<CountryRegionDict, Long> {
    List<CountryRegionDict> getAll();
    List<CountryRegionDict> getRegions();
}
