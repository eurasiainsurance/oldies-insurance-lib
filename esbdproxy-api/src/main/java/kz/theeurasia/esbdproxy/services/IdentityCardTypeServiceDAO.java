package kz.theeurasia.esbdproxy.services;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.IdentityCardTypeDict;

public interface IdentityCardTypeServiceDAO extends EntityServiceDAO<IdentityCardTypeDict, Long> {
    List<IdentityCardTypeDict> getAll();
}
