package com.lapsa.insurance.persistence.dao;

import java.util.List;

public interface GeneralDAO<T, I> {
    T findById(I id) throws EntityNotFound, PeristenceOperationFailed;

    T findByIdByPassCache(I id) throws EntityNotFound, PeristenceOperationFailed;

    <ET extends T> ET save(ET entity) throws PeristenceOperationFailed;

    <ET extends T> ET reset(ET entity) throws PeristenceOperationFailed;

    void saveAll(List<T> entities) throws PeristenceOperationFailed;

    void enqueueSave(T entity);

    void enqueueSaveAll(List<T> entities);

    void flushQueued();


}
