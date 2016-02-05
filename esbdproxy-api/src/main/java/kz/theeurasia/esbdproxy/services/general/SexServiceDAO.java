package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.general.SexDict;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;

public interface SexServiceDAO extends GeneralServiceDAO<SexDict, Long> {
    List<SexDict> getAll();
}
