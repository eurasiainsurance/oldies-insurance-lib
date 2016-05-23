package com.lapsa.insurance.persistence.dao;

public interface DAO<T,I> {
    T findById(I id);

    T save(T entity);
    
    void enqueueSave(T entity);

    void flushQueued();
}
