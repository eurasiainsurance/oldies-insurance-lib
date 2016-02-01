package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.general.EconomicSectorDict;

public interface EconomicSectorServiceDAO extends DictServiceDAO<EconomicSectorDict, Long> {
    List<EconomicSectorDict> getAll();
}
