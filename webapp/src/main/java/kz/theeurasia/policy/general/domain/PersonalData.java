package kz.theeurasia.policy.general.domain;

import java.util.Date;

import kz.theeurasia.esbdproxy.domain.dict.general.SexDict;

public class PersonalData {
    private String name;

    private String surename;

    private String patronymic;

    private Date dayOfBirth;

    private SexDict sex = SexDict.UNSPECIFIED;

    // GENERATED

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getSurename() {
	return surename;
    }

    public void setSurename(String surename) {
	this.surename = surename;
    }

    public String getPatronymic() {
	return patronymic;
    }

    public void setPatronymic(String patronymic) {
	this.patronymic = patronymic;
    }

    public Date getDayOfBirth() {
	return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
	this.dayOfBirth = dayOfBirth;
    }

    public SexDict getSex() {
	return sex;
    }

    public void setSex(SexDict sex) {
	this.sex = sex;
    }


}
