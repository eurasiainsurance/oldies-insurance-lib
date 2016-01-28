package kz.theeurasia.esbdproxy.services;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.IdentityCardTypeInfo;

public interface IdentityCardTypeServiceDAO extends EntityServiceDAO<IdentityCardTypeInfo, Long> {
    List<IdentityCardTypeInfo> getAll();
}
