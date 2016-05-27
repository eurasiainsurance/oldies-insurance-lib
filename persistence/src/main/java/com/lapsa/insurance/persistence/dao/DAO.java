package com.lapsa.insurance.persistence.dao;

import java.util.List;

public interface DAO<T, I> {
    T findById(I id);

    T save(T entity) throws PeristenceOperationFailed;

    void saveAll(List<T> entities) throws PeristenceOperationFailed;

    void enqueueSave(T entity);

    void enqueueSaveAll(List<T> entities);

    void flushQueued();
}
