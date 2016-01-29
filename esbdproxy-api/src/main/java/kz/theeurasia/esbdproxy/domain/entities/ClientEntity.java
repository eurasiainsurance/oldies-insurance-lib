package kz.theeurasia.esbdproxy.domain.entities;

/**
 * Абстрактный класс для представления лица
 * 
 * @author vadim.isaev
 *
 */
public abstract class ClientEntity {
    private long id;

    public ClientEntity() {
    }

    public ClientEntity(long id) {
	this.id = id;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

}
