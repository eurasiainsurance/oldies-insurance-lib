package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.general.IdentityCardTypeDict;
import kz.theeurasia.esbdproxy.services.AbstractServiceDAO;

public interface IdentityCardTypeServiceDAO extends AbstractServiceDAO<IdentityCardTypeDict, Long> {
    List<IdentityCardTypeDict> getAll();
}
