package kz.theeurasia.esbdproxy.services.osgpovts;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuredAgeExpirienceClassDict;
import kz.theeurasia.esbdproxy.services.AbstractServiceDAO;

public interface InsuredAgeExpirienceClassServiceDAO extends AbstractServiceDAO<InsuredAgeExpirienceClassDict, Long> {
    List<InsuredAgeExpirienceClassDict> getAll();
}
