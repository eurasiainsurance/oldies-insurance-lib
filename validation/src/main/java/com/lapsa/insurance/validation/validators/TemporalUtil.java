package com.lapsa.insurance.validation.validators;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class TemporalUtil {

    private static final ZoneId DEFAULT_TZ = ZoneId.systemDefault();

    public static LocalDateTime toLocalDateTime(Date date) {
	return date == null ? null : LocalDateTime.ofInstant(date.toInstant(), DEFAULT_TZ);
    }

    public static LocalDateTime toLocalDateTime(Calendar calendar) {
	return calendar == null ? null : LocalDateTime.ofInstant(calendar.toInstant(), DEFAULT_TZ);
    }

    public static LocalDateTime toLocalDateTime(LocalDate localDate) {
	return localDate == null ? null : localDate.atStartOfDay();
    }

    public static LocalDate toLocalDate(Date date) {
	return date == null ? null : toLocalDate(toLocalDateTime(date));
    }

    public static LocalDate toLocalDate(Calendar calendar) {
	return calendar == null ? null : toLocalDate(toLocalDateTime(calendar));
    }

    public static LocalDate toLocalDate(LocalDateTime localDateTime) {
	return localDateTime == null ? null : localDateTime.toLocalDate();
    }

    public static Calendar toCalendar(Date date) {
	if (date == null)
	    return null;
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(date);
	return calendar;
    }

    public static Calendar toCalendar(LocalDate localDate) {
	return toCalendar(toDate(localDate));
    }

    public static Calendar toCalendar(LocalDateTime localDateTime) {
	return toCalendar(toDate(localDateTime));
    }

    public static Date toDate(Calendar calendar) {
	return calendar == null ? null : calendar.getTime();
    }

    public static Date toDate(LocalDate localDate) {
	return localDate == null ? null
		: Date.from(localDate.atStartOfDay().atZone(DEFAULT_TZ).toInstant());
    }

    public static Date toDate(LocalDateTime localDateTime) {
	return localDateTime == null ? null
		: Date.from(localDateTime.atZone(DEFAULT_TZ).toInstant());
    }

}
