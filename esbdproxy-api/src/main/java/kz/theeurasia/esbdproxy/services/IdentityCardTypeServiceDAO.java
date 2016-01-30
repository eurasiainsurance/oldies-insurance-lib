package kz.theeurasia.esbdproxy.services;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.IdentityCardTypeDict;

public interface IdentityCardTypeServiceDAO extends AbstractServiceDAO<IdentityCardTypeDict, Long> {
    List<IdentityCardTypeDict> getAll();
}
