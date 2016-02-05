package kz.theeurasia.esbdproxy.domain.entities.general;

import kz.theeurasia.esbdproxy.domain.dict.general.EconomicSectorDict;
import kz.theeurasia.esbdproxy.domain.enums.general.SubjectTypeEnum;
import kz.theeurasia.esbdproxy.domain.infos.general.ContactInfo;
import kz.theeurasia.esbdproxy.domain.infos.general.OriginInfo;

/**
 * Абстрактный класс для представления лица
 * 
 * @author vadim.isaev
 *
 */
public abstract class SubjectEntity {

    // ID s:int Идентификатор клиента (обязательно)
    private long id;

    // Natural_Person_Bool s:int Признак принадлежности к физ. лицу (1 - физ.
    // лицо; 0 - юр. лицо)(обязательно)
    public abstract SubjectTypeEnum getSubjectType();

    // RESIDENT_BOOL s:int Признак резидентства (обязательно)
    // COUNTRY_ID s:int Страна (справочник COUNTRIES)
    // SETTLEMENT_ID s:int Населенный пункт (справочник SETTLEMENTS)
    private OriginInfo origin = new OriginInfo();

    // PHONES s:string Номера телефонов
    // EMAIL s:string Адрес электронной почты
    // Address s:string Адрес
    // WWW s:string Сайт
    private ContactInfo contact = new ContactInfo();

    // TPRN s:string РНН
    private String taxPayerNumber;

    // DESCRIPTION s:string Примечание
    private String comments;

    // RESIDENT_BOOL s:int Признак резидентства (обязательно)
    private boolean resident;

    // IIN s:string ИИН/БИН
    private String idNumber;

    // BANKS tns:ArrayOfCLIENTBANK Содержит реквизиты банка клиента.

    // ECONOMICS_SECTOR_ID s:int Сектор экономики (справочник ECONOMICS_SECTORS)
    private EconomicSectorDict economicsSector = EconomicSectorDict.UNSPECIFIED;

    public abstract int hashCode();

    public abstract boolean equals(Object obj);

    // GENERATED

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public OriginInfo getOrigin() {
	return origin;
    }

    public void setOrigin(OriginInfo origin) {
	this.origin = origin;
    }

    public ContactInfo getContact() {
	return contact;
    }

    public void setContact(ContactInfo contact) {
	this.contact = contact;
    }

    public String getTaxPayerNumber() {
	return taxPayerNumber;
    }

    public void setTaxPayerNumber(String taxPayerNumber) {
	this.taxPayerNumber = taxPayerNumber;
    }

    public String getComments() {
	return comments;
    }

    public void setComments(String comments) {
	this.comments = comments;
    }

    public boolean isResident() {
	return resident;
    }

    public void setResident(boolean resident) {
	this.resident = resident;
    }

    public String getIdNumber() {
	return idNumber;
    }

    public void setIdNumber(String idNumber) {
	this.idNumber = idNumber;
    }

    public EconomicSectorDict getEconomicsSector() {
	return economicsSector;
    }

    public void setEconomicsSector(EconomicSectorDict economicsSector) {
	this.economicsSector = economicsSector;
    }

}
