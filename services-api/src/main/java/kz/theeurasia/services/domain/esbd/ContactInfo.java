package kz.theeurasia.services.domain.esbd;

/**
 * Класс для представления контактных данных
 * 
 * @author vadim.isaev
 *
 */
public class ContactInfo {

    private String phone;
    private String email;
    private String homeAdress;

    public ContactInfo() {
    }

    public ContactInfo(String phone, String email, String homeAdress) {
	super();
	this.phone = phone;
	this.email = email;
	this.homeAdress = homeAdress;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getHomeAdress() {
	return homeAdress;
    }

    public void setHomeAdress(String postAdress) {
	this.homeAdress = postAdress;
    }

}
