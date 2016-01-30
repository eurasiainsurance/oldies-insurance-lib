package kz.theeurasia.esbdproxy.services;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.EconomicSectorDict;

public interface EconomicSectorServiceDAO extends DictServiceDAO<EconomicSectorDict, Long> {
    List<EconomicSectorDict> getAll();
}
