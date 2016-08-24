package com.lapsa.insurance.persistence.dao;

import java.util.List;

public interface GeneralDAO<T, I> {
    T findById(I id) throws EntityNotFound, PeristenceOperationFailed;

    T findByIdByPassCache(I id) throws EntityNotFound, PeristenceOperationFailed;

    <Z extends T> Z save(Z entity) throws PeristenceOperationFailed;

    <Z extends T> void reset(Z entity) throws PeristenceOperationFailed;

    void saveAll(List<T> entities) throws PeristenceOperationFailed;

    void enqueueSave(T entity);

    void enqueueSaveAll(List<T> entities);

    void flushQueued();


}
