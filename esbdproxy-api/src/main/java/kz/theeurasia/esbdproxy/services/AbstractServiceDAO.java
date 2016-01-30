package kz.theeurasia.esbdproxy.services;

public interface AbstractServiceDAO<T, I> {
    T getById(I id) throws NotFound;
}
