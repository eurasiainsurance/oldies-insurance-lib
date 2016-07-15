package kz.theeurasia.esbdproxy.services;

public interface GeneralServiceDAO<T, I> {
    T getById(I id) throws NotFound, InvalidInputParameter;
}
