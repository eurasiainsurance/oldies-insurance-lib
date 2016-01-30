package kz.theeurasia.esbdproxy.services.ejbimpl.entity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.ArrayOfItem;
import kz.theeurasia.asb.esbd.jaxws.Item;
import kz.theeurasia.esbdproxy.domain.entities.BranchEntity;
import kz.theeurasia.esbdproxy.services.BranchServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

@Singleton
public class BranchEntityServiceWS extends AbstractESBDEntityServiceWS implements BranchServiceDAO {

    private static final String DICT_NAME = "BRANCHES";

    private List<BranchEntity> all;

    @PostConstruct
    protected void init() {
	checkSession();
	all = new ArrayList<>();
	ArrayOfItem items = getSoapService().getItems(getSessionId(), DICT_NAME);
	if (items == null)
	    return;
	for (Item i : items.getItem()) {
	    BranchEntity e = new BranchEntity();
	    fillValues(i, e);
	    all.add(e);
	}
    }

    @Override
    public BranchEntity getById(Long id) throws NotFound {
	for (BranchEntity be : all)
	    if (be.getId() == id)
		return be;
	throw new NotFound(BranchEntity.class.getSimpleName() + " not found with ID = '" + id + "'");
    }

    void fillValues(Item source, BranchEntity target) {
	target.setId(source.getID());
	target.setCode(source.getCode());
	target.setName(source.getName());
    }

}
