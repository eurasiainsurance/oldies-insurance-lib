package com.lapsa.insurance.domain;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.patterns.domain.Domain;

public abstract class BaseEntity<T> extends Domain {

    private static final long serialVersionUID = 1L;

    protected BaseEntity() {
    }

    protected BaseEntity(final T id) {
	this.id = MyObjects.requireNonNull(id, "id");
    }

    // id

    protected T id;

    public T getId() {
	return id;
    }

    protected String appendEntityId() {
	return appendEntityId(id);
    }

    protected static String appendEntityId(final Object id) {
	return " [ID=" + MyOptionals.of(id).map(Object::toString).orElse("NONE") + "]";
    }
}
