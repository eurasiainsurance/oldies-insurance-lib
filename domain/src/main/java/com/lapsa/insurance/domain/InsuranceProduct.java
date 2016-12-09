package com.lapsa.insurance.domain;

public abstract class InsuranceProduct extends BaseEntity<Integer> {
    private static final long serialVersionUID = -9132371112866863979L;

    protected CalculationData calculation = new CalculationData();

    // GENERATED

    public CalculationData getCalculation() {
	return calculation;
    }

    public void setCalculation(CalculationData calculation) {
	this.calculation = calculation;
    }

}
