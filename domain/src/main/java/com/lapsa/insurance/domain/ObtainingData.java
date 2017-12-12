package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.time.LocalDate;
import java.util.Locale;
import java.util.StringJoiner;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lapsa.insurance.elements.DeliveryTimeSlot;
import com.lapsa.insurance.elements.ObtainingMethod;
import com.lapsa.insurance.elements.ObtainingStatus;
import com.lapsa.kz.country.KZCity;

import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.java.commons.function.MyStrings;
import tech.lapsa.java.commons.localization.Localized;
import tech.lapsa.javax.validation.DaysAfterNow;
import tech.lapsa.javax.validation.DaysBeforeNow;
import tech.lapsa.javax.validation.Mode;
import tech.lapsa.javax.validation.NotEmptyString;
import tech.lapsa.javax.validation.NotNullValue;
import tech.lapsa.patterns.domain.HashCodePrime;

@Embeddable
@HashCodePrime(89)
public class ObtainingData extends Domain {

    private static final long serialVersionUID = 1L;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "OBTAINING_METHOD")
    @NotNullValue(message = "{com.lapsa.insurance.domain.ObtainingData.method.NotNullValue.message}")
    private ObtainingMethod method = ObtainingMethod.UNDEFINED;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "OBTAINING_STATUS")
    @NotNullValue
    private ObtainingStatus status = ObtainingStatus.UNDEFINED;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "OBTAINING_PICKUP_CITY")
    @NotNullValue(message = "{com.lapsa.insurance.domain.ObtainingData.pickupCity.NotNullValue.message}")
    private KZCity pickupCity;

    @ManyToOne
    @JoinColumn(name = "OBTAINING_PICKUPPOS_ID")
    @NotNullValue(message = "{com.lapsa.insurance.domain.ObtainingData.pickupPOS.NotNullValue.message}")
    private CompanyPointOfSale pickupPOS;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "OBTAINING_DELIVERY_DATE")
    @NotNullValue(message = "{com.lapsa.insurance.domain.ObtainingData.deliveryDate.NotNullValue.message}")
    @DaysAfterNow(mode = Mode.MUST, value = 0, message = "{com.lapsa.insurance.domain.ObtainingData.deliveryDate.DaysAfterNow.messages}")
    @DaysBeforeNow(mode = Mode.MUST_NOT, value = 7, message = "{com.lapsa.insurance.domain.ObtainingData.deliveryDate.DaysBeforeNow.messages}")
    private LocalDate deliveryDate;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "OBTAINING_DELIVERY_TIME")
    @NotNullValue(message = "{com.lapsa.insurance.domain.ObtainingData.deliveryTime.NotNullValue.message}")
    private DeliveryTimeSlot deliveryTime;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "OBTAINING_DELIVERY_CITY")
    @NotNullValue(message = "{com.lapsa.insurance.domain.ObtainingData.deliveryCity.NotNullValue.message}")
    private KZCity deliveryCity;

    @Basic
    @Column(name = "OBTAINING_DELIVERY_ADDRESS")
    @NotNullValue(message = "{com.lapsa.insurance.domain.ObtainingData.deliveryAddress.NotNullValue.message}")
    @NotEmptyString(message = "{com.lapsa.insurance.domain.ObtainingData.deliveryAddress.NotEmptyString.message}")
    private String deliveryAddress;

    @Override
    public void unlazy() {
	super.unlazy();
	MyOptionals.of(getPickupPOS()).ifPresent(Domain::unlazy);
    }

    @Override
    public String localized(LocalizationVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(MyOptionals.of(method) //
		.filter(ObtainingMethod::isDefined) //
		.map(Localized.toLocalizedMapper(variant, locale)) //
		.map(MyStrings::capitalizeFirstLetter) //
		.orElseGet(() -> OBTAINING_DATA.localized(variant, locale)));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	MyOptionals.of(status) //
		.filter(ObtainingStatus::isDefined) //
		.map(Localized.toLocalizedMapper(variant, locale)) //
		.map(FIELD_STATUS.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.toString();
    }

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
