package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.general.CancelationReasonDict;
import kz.theeurasia.esbdproxy.services.AbstractServiceDAO;

public interface CancelationReasonServiceDAO extends AbstractServiceDAO<CancelationReasonDict, Long> {
    List<CancelationReasonDict> getAll();
}
