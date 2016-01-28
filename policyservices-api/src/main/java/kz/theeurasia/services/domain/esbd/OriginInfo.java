package kz.theeurasia.services.domain.esbd;

/**
 * Класс для представления данных о происхождении клиента
 * 
 * @author vadim.isaev
 *
 */
public class OriginInfo {

    private int countryId;
    private String country;
    private boolean resident;

    public OriginInfo() {
    }

    public OriginInfo(int countryId, String country, boolean resident) {
	this.countryId = countryId;
	this.country = country;
	this.resident = resident;
    }

    public int getCountryId() {
	return countryId;
    }

    public void setCountryId(int countryId) {
	this.countryId = countryId;
    }

    public String getCountry() {
	return country;
    }

    public void setCountry(String country) {
	this.country = country;
    }

    public boolean isResident() {
	return resident;
    }

    public void setResident(boolean resident) {
	this.resident = resident;
    }

}
