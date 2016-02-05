package kz.theeurasia.esbdproxy.services.osgpovts;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuredAgeExpirienceClassDict;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;

public interface InsuredAgeExpirienceClassServiceDAO extends GeneralServiceDAO<InsuredAgeExpirienceClassDict, Long> {
    List<InsuredAgeExpirienceClassDict> getAll();
}
