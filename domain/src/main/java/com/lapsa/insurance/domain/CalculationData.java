package com.lapsa.insurance.domain;

import com.lapsa.fin.FinCurrency;
import com.lapsa.insurance.elements.TermClass;

public class CalculationData extends BaseDomain {
    private static final long serialVersionUID = -1769681003179820909L;
    private static final int PRIME = 3;
    private static final int MULTIPLIER = 3;

    private TermClass termClass = TermClass.YEAR;

    private double premiumCost;
    private FinCurrency premiumCurrency;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    // GENEERATED

    public TermClass getTermClass() {
	return termClass;
    }

    public void setTermClass(TermClass termClass) {
	this.termClass = termClass;
    }

    public double getPremiumCost() {
	return premiumCost;
    }

    public void setPremiumCost(double premiumCost) {
	this.premiumCost = premiumCost;
    }

    public FinCurrency getPremiumCurrency() {
	return premiumCurrency;
    }

    public void setPremiumCurrency(FinCurrency premiumCurrency) {
	this.premiumCurrency = premiumCurrency;
    }
}
