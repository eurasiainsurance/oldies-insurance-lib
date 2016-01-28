package kz.theeurasia.esbdproxy.services;

public interface EntityServiceDAO<T, I> {
    T getById(I id) throws NotFound;
}
