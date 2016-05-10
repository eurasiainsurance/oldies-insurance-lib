package com.lapsa.insurance.domain;

import java.util.Date;

import com.lapsa.insurance.elements.DeliveryTimeSlot;
import com.lapsa.insurance.elements.PolicyObtainingMethod;
import com.lapsa.insurance.validation.DaysAfterNow;
import com.lapsa.insurance.validation.DaysBeforeNow;
import com.lapsa.insurance.validation.Mode;
import com.lapsa.insurance.validation.NotEmptyString;
import com.lapsa.insurance.validation.NotNullValue;

public class PolicyObtainingData {

    @NotNullValue(message = "{com.lapsa.insurance.domain.PolicyObtainingData.method.NotNullValue.message}")
    private PolicyObtainingMethod method;

    @NotNullValue(message = "{com.lapsa.insurance.domain.PolicyObtainingData.deliveryDate.NotNullValue.message}")
    @DaysAfterNow(mode = Mode.MUST, value = 0, message = "{com.lapsa.insurance.domain.PolicyObtainingData.deliveryDate.DaysAfterNow.messages}")
    @DaysBeforeNow(mode = Mode.MUST_NOT, value = 7, message = "{com.lapsa.insurance.domain.PolicyObtainingData.deliveryDate.DaysBeforeNow.messages}")
    private Date deliveryDate;

    @NotNullValue(message = "{com.lapsa.insurance.domain.PolicyObtainingData.deliveryTime.NotNullValue.message}")
    private DeliveryTimeSlot deliveryTime;

    @NotNullValue(message = "{com.lapsa.insurance.domain.PolicyObtainingData.deliveryAddress.NotNullValue.message}")
    @NotEmptyString(message = "{com.lapsa.insurance.domain.PolicyObtainingData.deliveryAddress.NotEmptyString.message}")
    private String deliveryAddress;

    // GENERATED

    public PolicyObtainingMethod getMethod() {
	return method;
    }

    public void setMethod(PolicyObtainingMethod method) {
	this.method = method;
    }

    public Date getDeliveryDate() {
	return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
	this.deliveryDate = deliveryDate;
    }

    public DeliveryTimeSlot getDeliveryTime() {
	return deliveryTime;
    }

    public void setDeliveryTime(DeliveryTimeSlot deliveryTime) {
	this.deliveryTime = deliveryTime;
    }

    public String getDeliveryAddress() {
	return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
	this.deliveryAddress = deliveryAddress;
    }
}
