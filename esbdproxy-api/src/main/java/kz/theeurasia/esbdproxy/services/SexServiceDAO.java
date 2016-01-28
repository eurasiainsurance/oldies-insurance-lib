package kz.theeurasia.esbdproxy.services;

import java.util.List;

import kz.theeurasia.esbdproxy.dict.SexDict;

public interface SexServiceDAO extends EntityServiceDAO<SexDict, Long> {
    List<SexDict> getAll();
}
