package kz.theeurasia.esbdproxy.domain.infos;

import kz.theeurasia.esbdproxy.domain.dict.CityDict;
import kz.theeurasia.esbdproxy.domain.dict.CountryDict;

/**
 * Класс для представления данных о происхождении клиента
 * 
 * @author vadim.isaev
 *
 */
public class OriginInfo {

    // RESIDENT_BOOL s:int Признак резидентства (обязательно)
    private boolean resident;

    // COUNTRY_ID s:int Страна (справочник COUNTRIES)
    private CountryDict country = CountryDict.UNSPECIFIED;

    // SETTLEMENT_ID s:int Населенный пункт (справочник SETTLEMENTS)
    private CityDict city = CityDict.UNSPECIFIED;

    // GENERATED

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

    public CityDict getCity() {
	return city;
    }

    public void setCity(CityDict city) {
	this.city = city;
    }
}
