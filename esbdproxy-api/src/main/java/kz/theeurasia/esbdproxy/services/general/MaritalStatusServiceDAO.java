package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.general.MaritalStatusDict;
import kz.theeurasia.esbdproxy.services.AbstractServiceDAO;

public interface MaritalStatusServiceDAO extends AbstractServiceDAO<MaritalStatusDict, Long> {
    List<MaritalStatusDict> getAll();
}
