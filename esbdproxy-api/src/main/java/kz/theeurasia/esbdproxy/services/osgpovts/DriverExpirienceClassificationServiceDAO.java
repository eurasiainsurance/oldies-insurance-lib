package kz.theeurasia.esbdproxy.services.osgpovts;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.osgpovts.InsuredDriverExpirienceClassComplexDict;
import kz.theeurasia.esbdproxy.services.EntityServiceDAO;

public interface DriverExpirienceClassificationServiceDAO extends EntityServiceDAO<InsuredDriverExpirienceClassComplexDict, Long> {
    List<InsuredDriverExpirienceClassComplexDict> getAll();
}
