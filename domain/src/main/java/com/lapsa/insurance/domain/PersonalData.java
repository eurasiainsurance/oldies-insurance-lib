package com.lapsa.insurance.domain;

import java.time.LocalDate;

import com.lapsa.insurance.elements.Sex;
import com.lapsa.validation.NotEmptyString;
import com.lapsa.validation.NotNullValue;
import com.lapsa.validation.ValidDateOfBirth;
import com.lapsa.validation.ValidHumanName;

public class PersonalData extends BaseDomain {
    private static final long serialVersionUID = 6108831386319756885L;
    private static final int PRIME = 71;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

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
    private LocalDate dayOfBirth;

    @NotNullValue
    private Sex sex;

    public String getDisplayName() {
	return (((surename == null || surename.isEmpty()) ? "" : (surename + " "))
		+ ((name == null || name.isEmpty()) ? "" : (name + " "))
		+ ((patronymic == null || patronymic.isEmpty()) ? "" : (patronymic + " "))).trim();
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

    public LocalDate getDayOfBirth() {
	return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
	this.dayOfBirth = dayOfBirth;
    }

    public Sex getSex() {
	return sex;
    }

    public void setSex(Sex sex) {
	this.sex = sex;
    }
}
