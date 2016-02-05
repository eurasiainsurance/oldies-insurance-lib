package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.general.MaritalStatusDict;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;

public interface MaritalStatusServiceDAO extends GeneralServiceDAO<MaritalStatusDict, Long> {
    List<MaritalStatusDict> getAll();
}
