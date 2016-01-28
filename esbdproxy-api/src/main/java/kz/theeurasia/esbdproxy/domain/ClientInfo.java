package kz.theeurasia.esbdproxy.domain;

/**
 * Абстрактный класс для представления лица
 * 
 * @author vadim.isaev
 *
 */
public abstract class ClientInfo {
    private long id;

    public ClientInfo() {
    }

    public ClientInfo(long id) {
	this.id = id;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

}
