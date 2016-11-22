package com.lapsa.insurance.services.crm;

import java.util.List;

import javax.faces.model.SelectItem;

import com.lapsa.insurance.crm.PaymentStatus;
import com.lapsa.insurance.services.EnumService;

public interface PaymentStatusService extends EnumService<PaymentStatus> {

    List<PaymentStatus> getValueItems();

    List<SelectItem> getValueItemsSI();

    List<SelectItem> getValueItemsShortSI();

    List<SelectItem> getValueItemsFullSI();

    List<PaymentStatus> getNonValueItems();

    List<SelectItem> getNonValueItemsSI();

    List<SelectItem> getNonValueItemsShortSI();

    List<SelectItem> getNonValueItemsFullSI();
}
