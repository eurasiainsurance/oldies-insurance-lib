package kz.theeurasia.policy.domain;

import java.util.Date;

import com.lapsa.insurance.elements.DeliveryTimeSlot;
import com.lapsa.insurance.elements.PolicyObtainingMethod;

import kz.theeurasia.policy.validator.NotEmptyString;
import kz.theeurasia.policy.validator.NotNullValue;

public class PolicyObtainingData {

    @NotNullValue(message = "{kz.theeurasia.policy.domain.PolicyObtainingData.method.NotNullValue.message}")
    private PolicyObtainingMethod method;

    @NotNullValue(message = "{kz.theeurasia.policy.domain.PolicyObtainingData.deliveryDate.NotNullValue.message}")
    private Date deliveryDate;

    @NotNullValue(message = "{kz.theeurasia.policy.domain.PolicyObtainingData.deliveryTime.NotNullValue.message}")
    private DeliveryTimeSlot deliveryTime;

    @NotNullValue(message = "{kz.theeurasia.policy.domain.PolicyObtainingData.deliveryAddress.NotNullValue.message}")
    @NotEmptyString(message = "{kz.theeurasia.policy.domain.PolicyObtainingData.deliveryAddress.NotEmptyString.message}")
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
