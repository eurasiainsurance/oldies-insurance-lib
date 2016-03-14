package kz.theeurasia.policy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import kz.theeurasia.policy.domain.ScanCopiesTransferMethod;
import kz.theeurasia.policy.services.LocaleService;
import kz.theeurasia.policy.services.Messages;

@Named
@ApplicationScoped
public class ScanCopiesTransferMethodService {
    private ResourceBundle msg;

    @Inject
    private LocaleService localeService;

    @PostConstruct
    public void init() {
	msg = ResourceBundle.getBundle(Messages.BUNDLE_BASE_NAME, localeService.getLocale());
    }

    public List<ScanCopiesTransferMethod> getAllItems() {
	List<ScanCopiesTransferMethod> res = new ArrayList<>();
	for (ScanCopiesTransferMethod i : ScanCopiesTransferMethod.values())
	    res.add(i);
	return res;
    }

    public List<SelectItem> getAllItemsSI() {
	return _createSIFromList(getAllItems());
    }

    public List<ScanCopiesTransferMethod> getSelectableItems() {
	List<ScanCopiesTransferMethod> r = getAllItems();
	return r;
    }

    public List<SelectItem> getSelectableItemsSI() {
	return _createSIFromList(getSelectableItems());
    }

    private List<SelectItem> _createSIFromList(List<ScanCopiesTransferMethod> list) {
	List<SelectItem> result = new ArrayList<>();
	for (ScanCopiesTransferMethod r : list) {
	    SelectItem si = new SelectItem(r,
		    msg.getString(Messages.LABEL_SI_SCAN_COPIES_TRANSFER_METHOD_PREFIX.getCode() + r.name()));
	    result.add(si);
	}
	return result;
    }
}
