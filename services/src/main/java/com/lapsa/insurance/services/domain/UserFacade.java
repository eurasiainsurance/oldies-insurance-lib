package com.lapsa.insurance.services.domain;

import java.security.Principal;
import java.util.List;

import javax.faces.model.SelectItem;

import com.lapsa.insurance.domain.crm.User;

public interface UserFacade extends DomainService<User> {
    List<User> getAllItems();

    List<SelectItem> getAllItemsSI();

    List<SelectItem> getAllItemsShortSI();

    List<User> getSelectableItems();

    List<SelectItem> getSelectableItemsSI();

    List<SelectItem> getSelectableItemsShortSI();

    User findOrCreate(String principalName);

    User findOrCreate(Principal principal);

}
