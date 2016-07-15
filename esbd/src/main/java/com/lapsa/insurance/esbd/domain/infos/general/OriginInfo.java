package com.lapsa.insurance.esbd.domain.infos.general;

import com.lapsa.country.Country;
import com.lapsa.kz.country.KZCity;

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
    private Country country;

    // SETTLEMENT_ID s:int Населенный пункт (справочник SETTLEMENTS)
    private KZCity city;

    // GENERATED

    public boolean isResident() {
	return resident;
    }

    public void setResident(boolean resident) {
	this.resident = resident;
    }

    public Country getCountry() {
	return country;
    }

    public void setCountry(Country country) {
	this.country = country;
    }

    public KZCity getCity() {
	return city;
    }

    public void setCity(KZCity city) {
	this.city = city;
    }
}
