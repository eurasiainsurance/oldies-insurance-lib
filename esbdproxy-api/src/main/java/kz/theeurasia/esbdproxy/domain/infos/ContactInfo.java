package kz.theeurasia.esbdproxy.domain.infos;

/**
 * Класс для представления контактных данных
 * 
 * @author vadim.isaev
 *
 */
public class ContactInfo {

    // PHONES s:string Номера телефонов
    private String phone;

    // EMAIL s:string Адрес электронной почты
    private String email;

    // Address s:string Адрес
    private String homeAdress;

    // WWW s:string Сайт
    private String siteUrl;

    // GENERATED

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

    public String getSiteUrl() {
	return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
	this.siteUrl = siteUrl;
    }

}
