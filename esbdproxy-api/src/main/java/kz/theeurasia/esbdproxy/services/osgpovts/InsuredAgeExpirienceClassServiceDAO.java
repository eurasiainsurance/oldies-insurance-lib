package kz.theeurasia.esbdproxy.services.osgpovts;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuredAgeExpirienceClassDict;
import kz.theeurasia.esbdproxy.services.EntityServiceDAO;

public interface InsuredAgeExpirienceClassServiceDAO extends EntityServiceDAO<InsuredAgeExpirienceClassDict, Long> {
    List<InsuredAgeExpirienceClassDict> getAll();
}
