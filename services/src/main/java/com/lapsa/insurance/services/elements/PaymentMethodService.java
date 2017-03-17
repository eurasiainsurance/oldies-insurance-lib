package com.lapsa.insurance.services.elements;

import java.util.List;

import javax.faces.model.SelectItem;

import com.lapsa.insurance.elements.PaymentMethod;
import com.lapsa.insurance.services.EnumService;

public interface PaymentMethodService extends EnumService<PaymentMethod> {

    List<PaymentMethod> getValueItems();

    List<SelectItem> getValueItemsSI();

    List<SelectItem> getValueItemsShortSI();

    List<SelectItem> getValueItemsFullSI();
}
