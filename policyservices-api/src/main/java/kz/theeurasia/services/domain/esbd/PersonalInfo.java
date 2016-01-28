package kz.theeurasia.services.domain.esbd;

import java.util.Calendar;

import kz.theeurasia.services.domain.global.Sex;

/**
 * Класс для предсталвения основных персональных данных клиента
 * 
 * @author vadim.isaev
 *
 */
public class PersonalInfo {

    private String firstName;
    private String lastName;
    private String middleName;
    private Calendar dayOfBirth;
    private Sex sex;

    public PersonalInfo() {
    }

    public PersonalInfo(String firstName, String lastName, String middleName, Calendar dayOfBirth, Sex sex) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.middleName = middleName;
	this.dayOfBirth = dayOfBirth;
	this.sex = sex;
    }

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

    public Sex getSex() {
	return sex;
    }

    public void setSex(Sex sex) {
	this.sex = sex;
    }

}
