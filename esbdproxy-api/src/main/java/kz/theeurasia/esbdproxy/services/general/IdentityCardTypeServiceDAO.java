package kz.theeurasia.esbdproxy.services.general;

import java.util.List;

import kz.theeurasia.esbdproxy.domain.dict.general.IdentityCardTypeDict;
import kz.theeurasia.esbdproxy.services.GeneralServiceDAO;

public interface IdentityCardTypeServiceDAO extends GeneralServiceDAO<IdentityCardTypeDict, Long> {
    List<IdentityCardTypeDict> getAll();
}
