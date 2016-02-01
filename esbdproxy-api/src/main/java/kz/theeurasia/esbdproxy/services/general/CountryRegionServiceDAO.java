package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryRegionDict;
import kz.theeurasia.esbdproxy.services.AbstractServiceDAO;

public interface CountryRegionServiceDAO extends AbstractServiceDAO<CountryRegionDict, Long> {
    List<CountryRegionDict> getAll();
    List<CountryRegionDict> getRegions();
}
