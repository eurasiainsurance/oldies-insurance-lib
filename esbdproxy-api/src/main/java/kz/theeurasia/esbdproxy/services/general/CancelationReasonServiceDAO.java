package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.general.CancelationReasonDict;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;

public interface CancelationReasonServiceDAO extends GeneralServiceDAO<CancelationReasonDict, Long> {
    List<CancelationReasonDict> getAll();
}
