package kz.theeurasia.esbdproxy.services;

import java.util.List;

import kz.theeurasia.esbdproxy.dict.CountryRegionDict;

public interface CountryRegionServiceDAO extends EntityServiceDAO<CountryRegionDict, Long> {
    List<CountryRegionDict> getAll();
    List<CountryRegionDict> getRegions();
}
