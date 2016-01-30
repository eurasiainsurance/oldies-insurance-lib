package kz.theeurasia.esbdproxy.services;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.MaritalStatusDict;

public interface MaritalStatusServiceDAO extends AbstractServiceDAO<MaritalStatusDict, Long> {
    List<MaritalStatusDict> getAll();
}
