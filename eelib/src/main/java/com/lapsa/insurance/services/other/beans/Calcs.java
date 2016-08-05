package com.lapsa.insurance.services.other.beans;

import java.time.LocalDate;

public class Calcs {

    public static double roundMoney(final double input, int digs) {
	double output = input;
	output *= Math.pow(10, digs);
	output = Math.round(output);
	output /= Math.pow(10, digs);
	return output;
    }

    public static double roundMoney(final double input) {
	return roundMoney(input, 2);
    }

    public static double costAnnualToPeriod(double annualCost, LocalDate start, LocalDate end) {
	if (start.isAfter(end))
	    throw new RuntimeException("Start date is after the end date");
	double cost = 0;
	LocalDate c = start;
	while (c.isBefore(end) || c.isEqual(end)) {
	    cost += annualCost / (start.getChronology().isLeapYear(start.getYear()) ? 366 : 365);
	    c = c.plusDays(1);
	}
	return cost;
    }

    public static double costAnnualToPeriod(double annualCost, LocalDate start, int days) {
	LocalDate end = start.plusDays(days);
	return costAnnualToPeriod(annualCost, start, end);
    }


}
