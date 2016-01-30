package kz.theeurasia.esbdproxy.services.ejbimpl.entity.osgpovts;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.ArrayOfItem;
import kz.theeurasia.asb.esbd.jaxws.Item;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleModelEntity;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.VehicleModelServiceDAO;
import kz.theeurasia.esbdproxy.services.ejbimpl.entity.AbstractESBDEntityServiceWS;

@Singleton
public class VehicleModelEntityServiceWS extends AbstractESBDEntityServiceWS implements VehicleModelServiceDAO {

    private static final String DICT_NAME = "VOITURE_MODELS";

    private List<VehicleModelEntity> all;

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
	    VehicleModelEntity e = new VehicleModelEntity();
	    fillValues(i, e);
	    all.add(e);
	}
    }

    @Override
    public List<VehicleModelEntity> getAll() {
	lazyInit();
	return all;
    }

    @Override
    public VehicleModelEntity getById(Long id) throws NotFound {
	lazyInit();
	for (VehicleModelEntity be : all)
	    if (be.getId() == id)
		return be;
	throw new NotFound("Not found with ID = '" + id + "'");
    }

    void fillValues(Item source, VehicleModelEntity target) {
	target.setId(source.getID());
	target.setCode(source.getCode());
	target.setName(source.getName());
    }

}
