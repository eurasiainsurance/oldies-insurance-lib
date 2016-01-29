package kz.theeurasia.esbdproxy.domain.infos;

import kz.theeurasia.esbdproxy.domain.dict.CountryDict;

/**
 * Класс для представления данных о происхождении клиента
 * 
 * @author vadim.isaev
 *
 */
public class OriginInfo {

    private boolean resident;
    private CountryDict country;

    public OriginInfo() {
    }

    public OriginInfo(boolean resident, CountryDict country) {
	this.resident = resident;
	this.country = country;
    }

    public boolean isResident() {
	return resident;
    }

    public void setResident(boolean resident) {
	this.resident = resident;
    }

    public CountryDict getCountry() {
	return country;
    }

    public void setCountry(CountryDict country) {
	this.country = country;
    }

}
