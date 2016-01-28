package kz.theeurasia.esbd.services.ejbimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import kz.theeurasia.asb.esbd.jaxws.Item;
import kz.theeurasia.esbd.domain.DocumentTypeInfo;
import kz.theeurasia.esbd.services.DocumentTypeServiceDAO;
import kz.theeurasia.esbd.services.NotFound;

@Stateless
public class DocumentTypeServiceWS extends ESBDServiceWS implements DocumentTypeServiceDAO {

    private static final String DIRECTORY_NAME = "DOCUMENTS_TYPES";

    private List<DocumentTypeInfo> all;

    @PostConstruct
    protected void init() {
	// EAGER
	fetchAll();
    }

    private void fetchAll() {
	checkSession();
	all = new ArrayList<>();
	List<Item> items = getSoapService().getItems(getSessionId(), DIRECTORY_NAME).getItem();
	for (Item source : items) {
	    DocumentTypeInfo target = new DocumentTypeInfo();
	    fillValues(source, target);
	    all.add(target);
	}
    }

    void fillValues(Item source, DocumentTypeInfo target) {
	target.setId(source.getID());
	target.setName(source.getName());
    }

    @Override
    public DocumentTypeInfo getById(Long id) throws NotFound {
	for (DocumentTypeInfo dti : all) {
	    if (dti.getId() == id)
		return dti;
	}
	throw new NotFound();
    }

    @Override
    public List<DocumentTypeInfo> getAll() {
	return all;
    }

}
