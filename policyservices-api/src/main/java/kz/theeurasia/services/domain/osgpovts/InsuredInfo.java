package kz.theeurasia.services.domain.osgpovts;

import kz.theeurasia.services.domain.global.InsuranceClassType;

/**
 * Класс для представления сведений о застрахованных для расчета премии ОС ГПО
 * ВТС
 * 
 * @author vadim.isaev
 *
 */
public class InsuredInfo {
    private InsuredAgeClass insuredAgeClass;
    private DriverExpirienceClass driverExpirienceClass;
    private InsuranceClassType insuranceClassType;
    private boolean hasPrivilege;

    public InsuredInfo() {
    }

    public InsuredInfo(InsuredAgeClass ageClass, DriverExpirienceClass driverExpirienceClass,
	    InsuranceClassType insuranceClassType, boolean hasPrivilege) {
	this.insuredAgeClass = ageClass;
	this.driverExpirienceClass = driverExpirienceClass;
	this.insuranceClassType = insuranceClassType;
	this.hasPrivilege = hasPrivilege;
    }

    public InsuredAgeClass getInsuredAgeClass() {
	return insuredAgeClass;
    }

    public void setAgeClass(InsuredAgeClass insuredAgeClass) {
	this.insuredAgeClass = insuredAgeClass;
    }

    public DriverExpirienceClass getDriverExpirienceClass() {
	return driverExpirienceClass;
    }

    public void setDriverExpirienceClass(DriverExpirienceClass driverExpirienceClass) {
	this.driverExpirienceClass = driverExpirienceClass;
    }

    public InsuranceClassType getInsuranceClassType() {
	return insuranceClassType;
    }

    public void setInsuranceClassType(InsuranceClassType insuranceClassType) {
	this.insuranceClassType = insuranceClassType;
    }

    public boolean isHasPrivilege() {
	return hasPrivilege;
    }

    public void setHasPrivilege(boolean hasPrivilege) {
	this.hasPrivilege = hasPrivilege;
    }
}
