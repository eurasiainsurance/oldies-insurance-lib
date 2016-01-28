package kz.theeurasia.esbd.services;

import kz.theeurasia.esbd.domain.ClientInfo;

/**
 * Интерфейс для сервиса доступа к Client
 * 
 * @author vadim.isaev
 *
 */
public interface ClientServiceDAO extends EntityServiceDAO<ClientInfo, Long> {
    ClientInfo getByIDNumber(String idNumber) throws NotFound;
}
