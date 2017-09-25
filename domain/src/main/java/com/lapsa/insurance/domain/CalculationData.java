package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;

import com.lapsa.fin.FinCurrency;

public class CalculationData extends BaseDomain {
    private static final long serialVersionUID = -1769681003179820909L;
    private static final int PRIME = 3;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private double calculatedPremiumCost;
    private double actualPremiumCost;
    private double discountAmount;
    private FinCurrency premiumCurrency;

    public double getPremiumCost() {
	if (actualPremiumCost > 0)
	    return actualPremiumCost;
	if (discountAmount > calculatedPremiumCost)
	    return 0;
	return calculatedPremiumCost - discountAmount;
    }

    @Override
    public String displayName(DisplayNameVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();
	sb.append(CALCULATION_DATA.displayName(variant, locale));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.add(Optional.of(this) //
		.filter(x -> x.getPremiumCost() > 0)
		.map(x -> x.premiumCurrency)
		.map(x -> x.formatAmount(getPremiumCost())) //
		.orElse("<" + CALCULATION_DATA_UNDEFINED.displayName(variant, locale) + ">"));

	sb.append(sj.toString());

	return sb.toString();
    }

    // GENEERATED

    public double getCalculatedPremiumCost() {
	return calculatedPremiumCost;
    }

    public void setCalculatedPremiumCost(double calculatedPremiumCost) {
	this.calculatedPremiumCost = calculatedPremiumCost;
    }

    public double getActualPremiumCost() {
	return actualPremiumCost;
    }

    public void setActualPremiumCost(double actualPremiumCost) {
	this.actualPremiumCost = actualPremiumCost;
    }

    public double getDiscountAmount() {
	return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
	this.discountAmount = discountAmount;
    }

    public FinCurrency getPremiumCurrency() {
	return premiumCurrency;
    }

    public void setPremiumCurrency(FinCurrency premiumCurrency) {
	this.premiumCurrency = premiumCurrency;
    }
}
