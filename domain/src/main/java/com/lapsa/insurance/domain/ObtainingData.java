package com.lapsa.insurance.domain;

import java.time.LocalDate;

import com.lapsa.insurance.crm.ObtainingStatus;
import com.lapsa.insurance.elements.DeliveryTimeSlot;
import com.lapsa.insurance.elements.ObtainingMethod;
import com.lapsa.insurance.validation.DaysAfterNow;
import com.lapsa.insurance.validation.DaysBeforeNow;
import com.lapsa.insurance.validation.Mode;
import com.lapsa.insurance.validation.NotEmptyString;
import com.lapsa.insurance.validation.NotNullValue;
import com.lapsa.kz.country.KZCity;

public class ObtainingData extends BaseDomain {
    private static final long serialVersionUID = -6326848114328976035L;
    private static final int PRIME = 89;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    @NotNullValue(message = "{com.lapsa.insurance.domain.ObtainingData.method.NotNullValue.message}")
    private ObtainingMethod method = ObtainingMethod.UNDEFINED;

    @NotNullValue
    private ObtainingStatus status = ObtainingStatus.UNDEFINED;

    @NotNullValue(message = "{com.lapsa.insurance.domain.ObtainingData.pickupCity.NotNullValue.message}")
    private KZCity pickupCity;

    @NotNullValue(message = "{com.lapsa.insurance.domain.ObtainingData.pickupPOS.NotNullValue.message}")
    private CompanyPointOfSale pickupPOS;

    @NotNullValue(message = "{com.lapsa.insurance.domain.ObtainingData.deliveryDate.NotNullValue.message}")
    @DaysAfterNow(mode = Mode.MUST, value = 0, message = "{com.lapsa.insurance.domain.ObtainingData.deliveryDate.DaysAfterNow.messages}")
    @DaysBeforeNow(mode = Mode.MUST_NOT, value = 7, message = "{com.lapsa.insurance.domain.ObtainingData.deliveryDate.DaysBeforeNow.messages}")
    private LocalDate deliveryDate;

    @NotNullValue(message = "{com.lapsa.insurance.domain.ObtainingData.deliveryTime.NotNullValue.message}")
    private DeliveryTimeSlot deliveryTime;

    @NotNullValue(message = "{com.lapsa.insurance.domain.ObtainingData.deliveryCity.NotNullValue.message}")
    private KZCity deliveryCity;

    @NotNullValue(message = "{com.lapsa.insurance.domain.ObtainingData.deliveryAddress.NotNullValue.message}")
    @NotEmptyString(message = "{com.lapsa.insurance.domain.ObtainingData.deliveryAddress.NotEmptyString.message}")
    private String deliveryAddress;

    // GENERATED

    public ObtainingMethod getMethod() {
	return method;
    }

    public void setMethod(ObtainingMethod method) {
	this.method = method;
    }

    public ObtainingStatus getStatus() {
	return status;
    }

    public void setStatus(ObtainingStatus status) {
	this.status = status;
    }

    public KZCity getPickupCity() {
	return pickupCity;
    }

    public void setPickupCity(KZCity pickupCity) {
	this.pickupCity = pickupCity;
    }

    public CompanyPointOfSale getPickupPOS() {
	return pickupPOS;
    }

    public void setPickupPOS(CompanyPointOfSale pickupPOS) {
	this.pickupPOS = pickupPOS;
    }

    public LocalDate getDeliveryDate() {
	return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
	this.deliveryDate = deliveryDate;
    }

    public DeliveryTimeSlot getDeliveryTime() {
	return deliveryTime;
    }

    public void setDeliveryTime(DeliveryTimeSlot deliveryTime) {
	this.deliveryTime = deliveryTime;
    }

    public KZCity getDeliveryCity() {
	return deliveryCity;
    }

    public void setDeliveryCity(KZCity deliveryCity) {
	this.deliveryCity = deliveryCity;
    }

    public String getDeliveryAddress() {
	return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
	this.deliveryAddress = deliveryAddress;
    }
}
