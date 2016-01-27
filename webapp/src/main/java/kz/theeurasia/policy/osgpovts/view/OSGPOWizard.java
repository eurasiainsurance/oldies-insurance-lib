package kz.theeurasia.policy.osgpovts.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FlowEvent;

@ManagedBean(name = "osgpoWizard")
@ViewScoped
public class OSGPOWizard implements Serializable {

    private static final long serialVersionUID = -3807022155354026265L;

    public String onFlowProcess(FlowEvent event) {
	return event.getNewStep();
    }
}