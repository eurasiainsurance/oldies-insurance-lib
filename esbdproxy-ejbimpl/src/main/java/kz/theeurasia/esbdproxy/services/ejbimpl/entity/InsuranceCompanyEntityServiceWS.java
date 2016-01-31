package kz.theeurasia.esbdproxy.services.ejbimpl.entity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.ArrayOfItem;
import kz.theeurasia.asb.esbd.jaxws.Item;
import kz.theeurasia.esbdproxy.domain.entities.InsuranceCompanyEntity;
import kz.theeurasia.esbdproxy.services.InsuranceCompanyServiceDAO;
import kz.theeurasia.esbdproxy.services.NotFound;

@Singleton
public class InsuranceCompanyEntityServiceWS extends AbstractESBDEntityServiceWS implements InsuranceCompanyServiceDAO {

    private static final String DICT_NAME = "INSURANCE_COMPANIES";

    private List<InsuranceCompanyEntity> all;

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
	    InsuranceCompanyEntity e = new InsuranceCompanyEntity();
	    fillValues(i, e);
	    all.add(e);
	}
    }

    @Override
    public List<InsuranceCompanyEntity> getAll() {
	lazyInit();
	return new ArrayList<>(all);
    }

    @Override
    public InsuranceCompanyEntity getById(Long id) throws NotFound {
	lazyInit();
	for (InsuranceCompanyEntity be : all)
	    if (be.getId() == id)
		return be;
	throw new NotFound(InsuranceCompanyEntity.class.getSimpleName() + " not found with ID = '" + id + "'");
    }

    void fillValues(Item source, InsuranceCompanyEntity target) {
	target.setId(source.getID());
	target.setCode(source.getCode());
	target.setName(source.getName());
    }

}
