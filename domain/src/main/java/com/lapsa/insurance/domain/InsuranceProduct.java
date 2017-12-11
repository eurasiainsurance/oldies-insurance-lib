package com.lapsa.insurance.domain;

public abstract class InsuranceProduct extends BaseEntity {
    private static final long serialVersionUID = -9132371112866863979L;

    protected CalculationData calculation = new CalculationData();
    protected InsurancePeriodData period;

    // GENERATED

    public CalculationData getCalculation() {
	return calculation;
    }

    public void setCalculation(CalculationData calculation) {
	this.calculation = calculation;
    }

    public InsurancePeriodData getPeriod() {
	return period;
    }

    public void setPeriod(InsurancePeriodData period) {
	this.period = period;
    }
}
