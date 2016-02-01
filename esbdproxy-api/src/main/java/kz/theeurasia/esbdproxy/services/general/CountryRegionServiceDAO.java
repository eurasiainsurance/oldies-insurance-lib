package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryRegionDict;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;

public interface CountryRegionServiceDAO extends GeneralServiceDAO<CountryRegionDict, Long> {
    List<CountryRegionDict> getAll();

    List<CountryRegionDict> getRegions();
}
