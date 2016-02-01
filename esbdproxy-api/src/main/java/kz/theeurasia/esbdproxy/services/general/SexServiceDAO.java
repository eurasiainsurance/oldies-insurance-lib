package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.general.SexDict;
import kz.theeurasia.esbdproxy.services.AbstractServiceDAO;

public interface SexServiceDAO extends AbstractServiceDAO<SexDict, Long> {
    List<SexDict> getAll();
}
