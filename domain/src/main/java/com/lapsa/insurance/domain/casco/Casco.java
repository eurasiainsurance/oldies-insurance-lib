package com.lapsa.insurance.domain.casco;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringJoiner;
import java.util.stream.Stream;

import javax.validation.constraints.Min;

import com.lapsa.fin.FinCurrency;
import com.lapsa.insurance.domain.BaseEntity;
import com.lapsa.insurance.domain.InsuranceProduct;
import com.lapsa.insurance.elements.CascoDeductibleFullRate;
import com.lapsa.insurance.elements.CascoDeductiblePartialRate;

import tech.lapsa.java.commons.function.MyNumbers;
import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.javax.validation.NotNullValue;
import tech.lapsa.patterns.domain.Domain;
import tech.lapsa.patterns.domain.HashCodePrime;

@HashCodePrime(131)
public class Casco extends InsuranceProduct {

    private static final long serialVersionUID = 1L;

    // Покрытие только риска ДТП
    private boolean coverRoadAccidents;

    // Покрытие без риска ДТП
    private boolean coverNonRoadAccidents;

    // информация о застрахованном ТС
    private CascoVehicle insuredVehicle;

    // информация о допущенных к управлению
    private List<CascoDriver> insuredDrivers = new ArrayList<>();

    // применяется ли франшиза на частичный ущерб
    private boolean deductiblePartialRequired;

    // размер франшизы на частичный ущерб
    @NotNullValue(message = "{com.lapsa.insurance.domain.casco.Casco.deductiblePartialRate.NotNullValue.message}")
    private CascoDeductiblePartialRate deductiblePartialRate;

    // франшиза на гибель/угон
    @NotNullValue(message = "{com.lapsa.insurance.domain.casco.Casco.deductibleFullRate.NotNullValue.message}")
    private CascoDeductibleFullRate deductibleFullRate;

    // Спец. СТО для ТС до 3-х лет
    // Спец. СТО для ТС от 3-х до 7 лет
    private boolean specialServiceStationRequired;

    // При убытке (ДТП) до 200 000 тенге - без вызова ГАИ, но с обязательным
    // выездом аварийного комиссара на место события (Алматы, Астана и
    // Караганда)
    private boolean noPoliceCallRequired;

    // При возникновении ДТП не по вине застрахованного франшиза не применяется
    private boolean noGuiltNoDeductibleRequired;

    // Сбор документов в Дорожной Полиции компанией от имени клиента
    private boolean helpWithPoliceRequired;

    // Покрытие расходов на услуги Эвакуатора, до 10 000 тенге.
    private boolean evacuatorRequired;

    // Предоставление во временное пользование ТС, пока ТС клиента находится на
    // СТО (до 10 дней);
    private boolean replacementCarRequired;

    // Действие договора до 1-го страхового случая
    private boolean contractEndsAfterFirstCase;

    // Комплексный договор (т.е. автокаско плюс секции ниже):
    // ДГПО ВТС с лимитом 20 000 000 тенге по случаю и в агрегате сверх лимита
    // по ОГПО ВТС
    private boolean thirdPartyLiabilityCoverage;

    // НС для водителя и пассажиров с лимитом 1 000 000 тенге на 1-го
    // застрахованного по случаю и в агрегате
    private boolean driverAndPassengerCoverage;

    @NotNullValue
    @Min(message = "{com.lapsa.insurance.domain.casco.Casco.driverAndPassengerCount.Min.message}", value = 1)
    private Integer driverAndPassengerCount;

    @Override
    public void unlazy() {
	super.unlazy();
	MyOptionals.of(getInsuredVehicle()).ifPresent(Domain::unlazy);
	MyOptionals.streamOf(getInsuredDrivers()) //
		.orElseGet(Stream::empty) //
		.filter(MyObjects::nonNull) //
		.forEach(BaseEntity::unlazy);
    }

    public CascoDriver addDriver(CascoDriver driver) {
	MyObjects.requireNonNull(driver, "Value must not be null");
	if (insuredDrivers == null)
	    insuredDrivers = new ArrayList<>();
	insuredDrivers.add(driver);
	return driver;
    }

    public CascoDriver removeDriver(CascoDriver driver) {
	MyObjects.requireNonNull(driver, "Value must not be null");
	if (insuredDrivers != null)
	    insuredDrivers.remove(driver);
	return driver;
    }

    @Override
    public String localized(LocalizationVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(CASCO.localized(variant, locale));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	MyOptionals.of(calculation) //
		.filter(x -> MyNumbers.nonZero(x.getPremiumCost())) //
		.filter(x -> MyObjects.nonNull(x.getPremiumCurrency()))
		.map(x -> x.getPremiumCurrency().formatAmount(x.getPremiumCost())) //
		.map(CASCO_COST.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(insuredVehicle)
		.map(x -> insuredVehicle.getCost())
		.filter(MyNumbers::nonZero)
		.map(x -> FinCurrency.KZT.formatAmount(x))
		.map(CASCO_CASCO_VEHICLE_COST.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.append(appendEntityId()) //
		.toString();
    }

    // GENERATED

    public boolean isCoverRoadAccidents() {
	return coverRoadAccidents;
    }

    public CascoVehicle getInsuredVehicle() {
	return insuredVehicle;
    }

    public void setInsuredVehicle(CascoVehicle insuredVehicle) {
	this.insuredVehicle = insuredVehicle;
    }

    public List<CascoDriver> getInsuredDrivers() {
	return insuredDrivers;
    }

    protected void setInsuredDrivers(List<CascoDriver> insuredDrivers) {
	this.insuredDrivers = insuredDrivers;
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

    public boolean isDeductiblePartialRequired() {
	return deductiblePartialRequired;
    }

    public void setDeductiblePartialRequired(boolean deductiblePartialRequired) {
	this.deductiblePartialRequired = deductiblePartialRequired;
    }

    public CascoDeductiblePartialRate getDeductiblePartialRate() {
	return deductiblePartialRate;
    }

    public void setDeductiblePartialRate(CascoDeductiblePartialRate deductiblePartialRate) {
	this.deductiblePartialRate = deductiblePartialRate;
    }

    public CascoDeductibleFullRate getDeductibleFullRate() {
	return deductibleFullRate;
    }

    public void setDeductibleFullRate(CascoDeductibleFullRate deductibleFullRate) {
	this.deductibleFullRate = deductibleFullRate;
    }

    public boolean isSpecialServiceStationRequired() {
	return specialServiceStationRequired;
    }

    public void setSpecialServiceStationRequired(boolean specialServiceStationRequired) {
	this.specialServiceStationRequired = specialServiceStationRequired;
    }

    public boolean isNoPoliceCallRequired() {
	return noPoliceCallRequired;
    }

    public void setNoPoliceCallRequired(boolean noPoliceCallRequired) {
	this.noPoliceCallRequired = noPoliceCallRequired;
    }

    public boolean isNoGuiltNoDeductibleRequired() {
	return noGuiltNoDeductibleRequired;
    }

    public void setNoGuiltNoDeductibleRequired(boolean noGuiltNoDeductibleRequired) {
	this.noGuiltNoDeductibleRequired = noGuiltNoDeductibleRequired;
    }

    public boolean isHelpWithPoliceRequired() {
	return helpWithPoliceRequired;
    }

    public void setHelpWithPoliceRequired(boolean helpWithPoliceRequired) {
	this.helpWithPoliceRequired = helpWithPoliceRequired;
    }

    public boolean isEvacuatorRequired() {
	return evacuatorRequired;
    }

    public void setEvacuatorRequired(boolean evacuatorRequired) {
	this.evacuatorRequired = evacuatorRequired;
    }

    public boolean isReplacementCarRequired() {
	return replacementCarRequired;
    }

    public void setReplacementCarRequired(boolean replacementCarRequired) {
	this.replacementCarRequired = replacementCarRequired;
    }

    public boolean isContractEndsAfterFirstCase() {
	return contractEndsAfterFirstCase;
    }

    public void setContractEndsAfterFirstCase(boolean contractEndsAfterFirstCase) {
	this.contractEndsAfterFirstCase = contractEndsAfterFirstCase;
    }

    public boolean isThirdPartyLiabilityCoverage() {
	return thirdPartyLiabilityCoverage;
    }

    public void setThirdPartyLiabilityCoverage(boolean thirdPartyLiabilityCoverage) {
	this.thirdPartyLiabilityCoverage = thirdPartyLiabilityCoverage;
    }

    public boolean isDriverAndPassengerCoverage() {
	return driverAndPassengerCoverage;
    }

    public void setDriverAndPassengerCoverage(boolean driverAndPassengerCoverage) {
	this.driverAndPassengerCoverage = driverAndPassengerCoverage;
    }

    public Integer getDriverAndPassengerCount() {
	return driverAndPassengerCount;
    }

    public void setDriverAndPassengerCount(Integer driverAndPassengerCount) {
	this.driverAndPassengerCount = driverAndPassengerCount;
    }
}
