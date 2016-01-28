package kz.theeurasia.esbdproxy.domain;

public class IdentityCardTypeInfo {
    private long id;
    private String name;

    public IdentityCardTypeInfo() {
    }

    public IdentityCardTypeInfo(long id, String name) {
	this.id = id;
	this.name = name;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
