package kz.theeurasia.esbdproxy.domain.infos.general;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryDict;
import kz.theeurasia.esbdproxy.domain.entities.general.CityEntity;

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
    private CityEntity city;

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

    public CityEntity getCity() {
	return city;
    }

    public void setCity(CityEntity city) {
	this.city = city;
    }
}
