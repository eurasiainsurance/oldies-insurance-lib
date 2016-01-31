package kz.theeurasia.esbdproxy.services.ejbimpl.entity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.ArrayOfItem;
import kz.theeurasia.asb.esbd.jaxws.Item;
import kz.theeurasia.esbdproxy.domain.entities.CityEntity;
import kz.theeurasia.esbdproxy.services.CityServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

@Singleton
public class CityEntityServiceWS extends AbstractESBDEntityServiceWS
	implements CityServiceDAO {

    private static final String DICT_NAME = "SETTLEMENTS";

    private List<CityEntity> all;

    @PostConstruct
    protected void init() {
    }

    private void lazyInit() {
	if (all != null)
	    return;
	checkSession();
	all = new ArrayList<>();
	ArrayOfItem items = getSoapService().getItems(getSessionId(), DICT_NAME);
	if (items == null)
	    return;
	for (Item i : items.getItem()) {
	    CityEntity e = new CityEntity();
	    fillValues(i, e);
	    all.add(e);
	}
    }

    @Override
    public List<CityEntity> getAll() {
	lazyInit();
	return new ArrayList<>(all);
    }

    @Override
    public CityEntity getById(Long id) throws NotFound {
	lazyInit();
	for (CityEntity be : all)
	    if (be.getId() == id)
		return be;
	throw new NotFound(CityEntity.class.getSimpleName() + " not found with ID = '" + id + "'");
    }

    void fillValues(Item source, CityEntity target) {
	target.setId(source.getID());
	target.setName(source.getName());
    }

}
