package kz.theeurasia.esbdproxy.services;

import kz.theeurasia.esbdproxy.domain.entities.ClientEntity;

public interface ClientServiceDAO extends EntityServiceDAO<ClientEntity, Long>  {
    ClientEntity getById(Long id) throws NotFound;
}
