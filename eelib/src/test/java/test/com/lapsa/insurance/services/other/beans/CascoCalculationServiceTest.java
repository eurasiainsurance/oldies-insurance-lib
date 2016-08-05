package test.com.lapsa.insurance.services.other.beans;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.lapsa.insurance.domain.CalculationData;
import com.lapsa.insurance.domain.casco.Casco;
import com.lapsa.insurance.domain.casco.CascoVehicle;
import com.lapsa.insurance.elements.CascoCarAgeClass;
import com.lapsa.insurance.elements.CascoDeductibleFullDeathRate;
import com.lapsa.insurance.elements.CascoDeductiblePartialDamageRate;
import com.lapsa.insurance.services.other.CalculationFailed;
import com.lapsa.insurance.services.other.CascoCalculationService;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;

public class CascoCalculationServiceTest {

    @Inject
    private CascoCalculationService s;

    @Test
    public void testCascoCalculationVariant1() throws CalculationFailed {
	Casco casco = generateCasco();
	s.calculateCascoCost(casco);
	assertThat(casco.getCalculation().getPremiumCost(), equalTo(282993.75d));
    }

    @Test
    public void testCascoCalculationVariant2() throws CalculationFailed {
	Casco casco = generateCasco();
	casco.setDeductiblePartialDamageRate(CascoDeductiblePartialDamageRate.PERCENT2);
	s.calculateCascoCost(casco);
	assertThat(casco.getCalculation().getPremiumCost(), equalTo(177375.00d));
    }

    @Test
    public void testCascoCalculationVariant3() throws CalculationFailed {
	Casco casco = generateCasco();
	casco.setDeductiblePartialDamageRate(CascoDeductiblePartialDamageRate.PERCENT10);
	casco.getInsuredVehicle().setCarAgeClass(CascoCarAgeClass.UNDER3);
	casco.setNoPoliceCallRequired(false);
	casco.setNoGuiltNoDeductibleRequired(false);
	casco.setDeductibleFullDeathRate(CascoDeductibleFullDeathRate.PERCENT10);
	casco.setReplacementCarRequired(false);

	casco.setCoverRoadAccidents(false);
	casco.setCoverNonRoadAccidents(true);

	s.calculateCascoCost(casco);
	assertThat(casco.getCalculation().getPremiumCost(), equalTo(50000.00d));
    }

    private Casco generateCasco() {
	Casco casco = new Casco();
	casco.setCalculation(new CalculationData());

	casco.setInsuredVehicle(new CascoVehicle());
	casco.getInsuredVehicle().setCost(5000000d);
	casco.getInsuredVehicle().setYearOfIssue(2008);
	casco.getInsuredVehicle().setCarAgeClass(CascoCarAgeClass.FROM3TO7);
	casco.getInsuredVehicle().setRegion(KZArea.GALM);
	casco.getInsuredVehicle().setCity(KZCity.ALM);

	casco.setDeductiblePartialDamageRate(CascoDeductiblePartialDamageRate.ZERO);

	casco.setSpecialServiceStationRequired(true);
	casco.setNoPoliceCallRequired(true);
	casco.setNoGuiltNoDeductibleRequired(true);
	casco.setDeductibleFullDeathRate(CascoDeductibleFullDeathRate.PERCENT5);
	casco.setHelpWithPoliceRequired(true);
	casco.setEvacuatorRequired(true);
	casco.setReplacementCarRequired(true);

	casco.setCoverRoadAccidents(true);
	casco.setCoverNonRoadAccidents(false);
	casco.setContractEndsAfterFirstCase(false);

	casco.setThirdPartyLiabilityCoverage(false);
	casco.setDriverAndPassengerCoverage(false);
	casco.setDriverAndPassengerCount(0);
	return casco;
    }

}
