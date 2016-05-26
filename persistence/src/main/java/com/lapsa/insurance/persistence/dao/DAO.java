package com.lapsa.insurance.persistence.dao;

import java.util.Collection;
import java.util.List;

public interface DAO<T, I> {
    T findById(I id);

    T save(T entity);

    void saveAll(List<T> entities);

    void enqueueSave(T entity);

    void enqueueSaveAll(List<T> entities);

    void flushQueued();
}
