package com.lapsa.insurance.domain;

import java.util.Date;

import com.lapsa.insurance.elements.Sex;
import com.lapsa.insurance.validation.NotEmptyString;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.insurance.validation.ValidDateOfBirth;
import com.lapsa.insurance.validation.ValidHumanName;
import com.lapsa.insurance.validation.ValidSex;

public class PersonalData extends BaseDomain {
    private static final long serialVersionUID = 6108831386319756885L;
    private static final int PRIME = 71;
    private static final int MULTIPLIER = 71;

    @NotNullValue
    @NotEmptyString
    @ValidHumanName
    private String name;

    @NotNullValue
    @NotEmptyString
    @ValidHumanName
    private String surename;

    @NotNullValue
    @NotEmptyString
    @ValidHumanName
    private String patronymic;

    @NotNullValue
    @ValidDateOfBirth
    private Date dayOfBirth;

    @NotNullValue
    @ValidSex
    private Sex sex;

    public String getDisplayName() {
	return (((surename == null || surename.isEmpty()) ? "" : (surename + " "))
		+ ((name == null || name.isEmpty()) ? "" : (name + " "))
		+ ((patronymic == null || patronymic.isEmpty()) ? "" : (patronymic + " "))).trim();
    }

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

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

    public Sex getSex() {
	return sex;
    }

    public void setSex(Sex sex) {
	this.sex = sex;
    }
}
