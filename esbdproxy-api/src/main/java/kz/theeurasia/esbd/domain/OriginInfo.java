package kz.theeurasia.esbd.domain;

/**
 * Класс для представления данных о происхождении клиента
 * 
 * @author vadim.isaev
 *
 */
public class OriginInfo {

    private boolean resident;
    private CountryInfo country;

    public OriginInfo() {
    }

    public OriginInfo(boolean resident, CountryInfo country) {
	this.resident = resident;
	this.country = country;
    }

    public boolean isResident() {
	return resident;
    }

    public void setResident(boolean resident) {
	this.resident = resident;
    }

    public CountryInfo getCountry() {
	return country;
    }

    public void setCountry(CountryInfo country) {
	this.country = country;
    }

}
