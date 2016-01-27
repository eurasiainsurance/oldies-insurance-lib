package kz.theeurasia.policy.osgpovts.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import kz.theeurasia.policy.osgpovts.domain.Insurant;

@ManagedBean
@ViewScoped
public class PolicyFormView {

    private Insurant insurant;

    public Insurant getInsurant() {
        return insurant;
    }

    public void setInsurant(Insurant insurant) {
        this.insurant = insurant;
    }
   
}
