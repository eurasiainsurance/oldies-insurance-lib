package kz.theeurasia.esbd.services;

public interface EntityServiceDAO<T, I> {
    T getById(I id) throws NotFound;
}
