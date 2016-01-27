package kz.theeurasia.policy.osgpovts.services;

import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import kz.theeurasia.policy.GlobalMessages;
import kz.theeurasia.policy.osgpovts.domain.Insured;
import kz.theeurasia.services.domain.esbd.ClientInfo;
import kz.theeurasia.services.domain.global.IdNumber;
import kz.theeurasia.services.domain.global.InsuranceClassType;
import kz.theeurasia.services.services.ESBDAccess;
import kz.theeurasia.services.services.ESBDException;
import kz.theeurasia.services.services.ESBDFaultException;
import kz.theeurasia.services.services.NotFound;

@ManagedBean
@ApplicationScoped
public class InsuredService {

    @EJB
    private ESBDAccess esbdAccessService;

    @ManagedProperty("#{glb}")
    private ResourceBundle glb;

    public void setGlb(ResourceBundle glb) {
	this.glb = glb;
    }

    public void fetchClientInfo(Insured insured) {
	if (insured.getIdNumber() == null | insured.getIdNumber().equals("")) {
	    insured.setClient(null);
	    insured.setInsuranceClassType(null);
	    return;
	}

	try {
	    InsuranceClassType classType = esbdAccessService
		    .getInsuranceClassTypeForIndividual(new IdNumber(insured.getIdNumber()));
	    insured.setInsuranceClassType(classType);
	    try {
		ClientInfo clientInfo = esbdAccessService.fetchClient(new IdNumber(insured.getIdNumber()));
		insured.setClient(clientInfo);
	    } catch (NotFound e) {
		insured.setClient(null);
	    }
	} catch (ESBDException | ESBDFaultException e) {
	    FacesContext
		    .getCurrentInstance()
		    .addMessage(null,
			    new FacesMessage(FacesMessage.SEVERITY_FATAL,
				    glb.getString(GlobalMessages.MESSAGES_SERVER_FATAL_ERROR_CAPTION),
				    glb.getString(GlobalMessages.MESSAGES_SERVER_FATAL_ERROR_DESCRIPTION)));
	}

    }
}
