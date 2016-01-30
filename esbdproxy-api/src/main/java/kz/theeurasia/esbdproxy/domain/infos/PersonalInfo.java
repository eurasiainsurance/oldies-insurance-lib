package kz.theeurasia.esbdproxy.domain.infos;

import java.util.Calendar;

import kz.theeurasia.esbdproxy.domain.dict.SexDict;

/**
 * Класс для предсталвения основных персональных данных клиента - физического
 * лица
 * 
 * @author vadim.isaev
 *
 */
public class PersonalInfo {

    // First_Name s:string Имя (для физ. лица)
    private String firstName;

    // Last_Name s:string Фамилия (для физ. лица)
    private String lastName;

    // Middle_Name s:string Отчество (для физ. лица)
    private String middleName;

    // Born s:string Дата рождения
    private Calendar dayOfBirth;

    // Sex_ID s:int Пол (справочник SEX)
    private SexDict sex = SexDict.UNSPECIFIED;

    // GENERATED

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getMiddleName() {
	return middleName;
    }

    public void setMiddleName(String middleName) {
	this.middleName = middleName;
    }

    public Calendar getDayOfBirth() {
	return dayOfBirth;
    }

    public void setDayOfBirth(Calendar dayOfBirth) {
	this.dayOfBirth = dayOfBirth;
    }

    public SexDict getSex() {
	return sex;
    }

    public void setSex(SexDict sex) {
	this.sex = sex;
    }

}
