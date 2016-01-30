package kz.theeurasia.esbdproxy.services.ejbimpl.entity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.ArrayOfItem;
import kz.theeurasia.asb.esbd.jaxws.Item;
import kz.theeurasia.esbdproxy.domain.entities.CompanyActivityKindEntity;
import kz.theeurasia.esbdproxy.services.CompanyActivityKindServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

@Singleton
public class CompanyActivityKindEntityServiceWS extends AbstractESBDEntityServiceWS
	implements CompanyActivityKindServiceDAO {

    private static final String DICT_NAME = "ACTIVITY_KINDS";

    private List<CompanyActivityKindEntity> all;

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
	    CompanyActivityKindEntity e = new CompanyActivityKindEntity();
	    fillValues(i, e);
	    all.add(e);
	}
    }

    @Override
    public List<CompanyActivityKindEntity> getAll() {
	lazyInit();
	return all;
    }

    @Override
    public CompanyActivityKindEntity getById(Long id) throws NotFound {
	lazyInit();
	for (CompanyActivityKindEntity be : all)
	    if (be.getId() == id)
		return be;
	throw new NotFound(CompanyActivityKindEntity.class.getSimpleName() + " not found with ID = '" + id + "'");
    }

    void fillValues(Item source, CompanyActivityKindEntity target) {
	target.setId(source.getID());
	target.setCode(source.getCode());
	target.setName(source.getName());
    }

}
