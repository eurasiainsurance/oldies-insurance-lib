package com.lapsa.insurance.services.elements;

import java.util.List;

import javax.faces.model.SelectItem;

import com.lapsa.insurance.elements.PaymentStatus;
import com.lapsa.insurance.services.EnumListingNamingService;

public interface PaymentStatusService extends EnumListingNamingService<PaymentStatus> {

    List<PaymentStatus> getValueItems();

    List<SelectItem> getValueItemsSI();

    List<SelectItem> getValueItemsShortSI();

    List<SelectItem> getValueItemsFullSI();

    List<PaymentStatus> getNonValueItems();

    List<SelectItem> getNonValueItemsSI();

    List<SelectItem> getNonValueItemsShortSI();

    List<SelectItem> getNonValueItemsFullSI();
}
