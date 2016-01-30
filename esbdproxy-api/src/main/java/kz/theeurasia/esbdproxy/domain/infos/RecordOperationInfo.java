package kz.theeurasia.esbdproxy.domain.infos;

import java.util.Calendar;

import kz.theeurasia.esbdproxy.domain.entities.UserEntity;

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
