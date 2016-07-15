package com.lapsa.insurance.esbd.domain.infos.general;

import java.util.Calendar;

import com.lapsa.insurance.esbd.domain.entities.general.UserEntity;

public class RecordOperationInfo {
    private Calendar date;
    private UserEntity author;

    // GENERATED

    public Calendar getDate() {
	return date;
    }

    public void setDate(Calendar date) {
	this.date = date;
    }

    public UserEntity getAuthor() {
	return author;
    }

    public void setAuthor(UserEntity author) {
	this.author = author;
    }

}
