package com.lapsa.insurance.domain.casco;

import com.lapsa.insurance.domain.BaseEntity;
import com.lapsa.insurance.domain.CalculationData;
import com.lapsa.insurance.elements.CascoDeductibleFullDeathRate;
import com.lapsa.insurance.elements.CascoDeductiblePartialDamageRate;

public class Casco extends BaseEntity<Integer> {
    private static final long serialVersionUID = -1919280207677627360L;
    private static final int PRIME = 131;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    // покрытие от ДТП
    private boolean coverRoadAccidents;

    // покрытие от других рисков
    private boolean coverNonRoadAccidents;

    // информация о застрахованном ТС
    private CascoVehicle insuredVehicle;

    // франшиза на частичный ущерб
    private CascoDeductiblePartialDamageRate deductiblePartialDamageRate;

    // франшиза на гибель/угон
    private CascoDeductibleFullDeathRate deductibleFullDeathRate;

    private CalculationData calculation;

    // GENERATED

    public CalculationData getCalculation() {
	return calculation;
    }

    public boolean isCoverRoadAccidents() {
	return coverRoadAccidents;
    }

    public CascoVehicle getInsuredVehicle() {
	return insuredVehicle;
    }

    public void setInsuredVehicle(CascoVehicle insuredVehicle) {
	this.insuredVehicle = insuredVehicle;
    }

    public void setCoverRoadAccidents(boolean coverRoadAccidents) {
	this.coverRoadAccidents = coverRoadAccidents;
    }

    public boolean isCoverNonRoadAccidents() {
	return coverNonRoadAccidents;
    }

    public void setCoverNonRoadAccidents(boolean coverNonRoadAccidents) {
	this.coverNonRoadAccidents = coverNonRoadAccidents;
    }

    public CascoDeductiblePartialDamageRate getDeductiblePartialDamageRate() {
	return deductiblePartialDamageRate;
    }

    public void setDeductiblePartialDamageRate(CascoDeductiblePartialDamageRate deductiblePartialDamageRate) {
	this.deductiblePartialDamageRate = deductiblePartialDamageRate;
    }

    public CascoDeductibleFullDeathRate getDeductibleFullDeathRate() {
	return deductibleFullDeathRate;
    }

    public void setDeductibleFullDeathRate(CascoDeductibleFullDeathRate deductibleFullDeathRate) {
	this.deductibleFullDeathRate = deductibleFullDeathRate;
    }

    public void setCalculation(CalculationData calculation) {
	this.calculation = calculation;
    }
}
