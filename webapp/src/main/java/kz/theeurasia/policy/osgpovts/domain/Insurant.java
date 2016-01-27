package kz.theeurasia.policy.osgpovts.domain;

import java.util.UUID;

public class Insurant {
    private final UUID id;

    public Insurant() {
	id = UUID.randomUUID();
    }

    public UUID getId() {
	return id;
    }

    @Override
    public int hashCode() {
	return this.getClass().hashCode() * id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	return obj != null && obj instanceof Insurant && getId().equals(((Insurant) obj).getId());
    }

}
