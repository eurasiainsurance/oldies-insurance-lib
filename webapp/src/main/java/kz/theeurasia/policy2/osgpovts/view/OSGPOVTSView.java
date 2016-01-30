package kz.theeurasia.policy2.osgpovts.view;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import kz.theeurasia.esbdproxy.domain.entities.osgpovts.PolicyEntity;
import kz.theeurasia.policy2.osgpovts.facade.PolicyFacade;
import kz.theeurasia.services.domain.osgpovts.PolicyTermClass;

@ManagedBean(name = "osgpovtsView")
@ViewScoped
public class OSGPOVTSView implements Serializable {

    private static final long serialVersionUID = 6605204552704504011L;

    @ManagedProperty("#{glb}")
    private ResourceBundle glb;

    public void setGlb(ResourceBundle glb) {
	this.glb = glb;
    }

    @ManagedProperty("#{policyFacade}")
    private PolicyFacade policyFacade;

    public void setPolicyFacade(PolicyFacade policyFacade) {
	this.policyFacade = policyFacade;
    }

    private PolicyEntity policy;

    public PolicyEntity getPolicy() {
	return policy;
    }

    private PolicyTermClass policyTermClass = PolicyTermClass.YEAR;

    public PolicyTermClass getPolicyTermClass() {
	return policyTermClass;
    }

    @PostConstruct
    public void init() {
	this.policy = policyFacade.createNew();
	this.policyTermClass = PolicyTermClass.YEAR;
    }

}
