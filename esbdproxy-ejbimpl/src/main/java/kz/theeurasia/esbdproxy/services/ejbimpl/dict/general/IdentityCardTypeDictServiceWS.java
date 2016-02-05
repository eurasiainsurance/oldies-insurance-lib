package kz.theeurasia.esbdproxy.services.ejbimpl.dict.general;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.esbdproxy.domain.dict.general.IdentityCardTypeDict;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.IdentityCardTypeServiceDAO;

@Singleton
public class IdentityCardTypeDictServiceWS implements IdentityCardTypeServiceDAO {

    private List<IdentityCardTypeDict> all;

    @PostConstruct
    protected void init() {
	all = new ArrayList<>();
	for (IdentityCardTypeDict cd : IdentityCardTypeDict.values())
	    all.add(cd);
    }

    @Override
    public IdentityCardTypeDict getById(Long id) throws NotFound {
	if (id == null)
	    throw new InvalidParameterException("ID must be not null");
	IdentityCardTypeDict result = IdentityCardTypeDict.forId(id);
	if (result == null)
	    throw new NotFound(IdentityCardTypeDict.class.getSimpleName() + " not found with ID = '" + id + "'");
	return result;
    }

    @Override
    public List<IdentityCardTypeDict> getAll() {
	return new ArrayList<>(all);
    }

}
