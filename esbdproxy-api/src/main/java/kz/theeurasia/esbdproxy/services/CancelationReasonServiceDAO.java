package kz.theeurasia.esbdproxy.services;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.CancelationReasonDict;

public interface CancelationReasonServiceDAO extends AbstractServiceDAO<CancelationReasonDict, Long> {
    List<CancelationReasonDict> getAll();
}
