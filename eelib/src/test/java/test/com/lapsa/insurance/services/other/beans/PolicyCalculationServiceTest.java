package test.com.lapsa.insurance.services.other.beans;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.inject.Inject;

import org.junit.Test;

import com.lapsa.insurance.domain.CalculationData;
import com.lapsa.insurance.domain.policy.Policy;
import com.lapsa.insurance.domain.policy.PolicyDriver;
import com.lapsa.insurance.domain.policy.PolicyVehicle;
import com.lapsa.insurance.elements.InsuranceClassType;
import com.lapsa.insurance.elements.InsuredAgeClass;
import com.lapsa.insurance.elements.InsuredExpirienceClass;
import com.lapsa.insurance.elements.VehicleAgeClass;
import com.lapsa.insurance.elements.VehicleClass;
import com.lapsa.insurance.services.other.CalculationFailed;
import com.lapsa.insurance.services.other.PolicyCalculationService;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;

public class PolicyCalculationServiceTest {

    @Inject
    private PolicyCalculationService s;

    @Test
    public void testPolicyCalculationVariant1() throws CalculationFailed {
	Policy policy = generatePolicy();
	s.calculatePolicyCost(policy);
	assertThat(policy.getCalculation().getPremiumCost(), equalTo(282993.75d));
    }

    // public static void main(String[] args) {
    // // %[argument_index$][flags][width][.precision]conversion
    // String fmt = "%30s : %30.15f";
    //
    // System.out.println(String.format(fmt, "Annual clean",
    // policy.getCalculation().getPremiumCost()));
    //
    // s.calculatePolicyCost(policy, LocalDate.now(), 365);
    // System.out.println(String.format(fmt, "365 days",
    // policy.getCalculation().getPremiumCost()));
    //
    // s.calculatePolicyCost(policy, LocalDate.now(),
    // LocalDate.now().plusMonths(1));
    // System.out.println(String.format(fmt, "Month",
    // policy.getCalculation().getPremiumCost()));
    //
    // s.calculatePolicyCost(policy, LocalDate.now(), LocalDate.now().plus(1,
    // ChronoUnit.YEARS));
    // System.out.println(String.format(fmt, "YEAR",
    // policy.getCalculation().getPremiumCost()));
    // }

    protected Policy generatePolicy() {
	Policy policy = new Policy();

	policy.setInsuredDrivers(new ArrayList<>());

	PolicyDriver d = new PolicyDriver();
	d.setIdNumber("123123123127");
	d.setInsuranceClassType(InsuranceClassType.CLASS_3);
	d.setAgeClass(InsuredAgeClass.OVER25);
	d.setExpirienceClass(InsuredExpirienceClass.LESS2);
	d.setHasAnyPrivilege(false);
	policy.getInsuredDrivers().add(d);

	policy.setInsuredVehicles(new ArrayList<>());

	PolicyVehicle v = new PolicyVehicle();
	v.setCity(KZCity.ALM);
	v.setRegion(KZArea.GALM);
	v.setVehicleClass(VehicleClass.CAR);
	v.setVehicleAgeClass(VehicleAgeClass.OVER7);
	policy.getInsuredVehicles().add(v);

	CalculationData c = new CalculationData();
	policy.setCalculation(c);
	return policy;
    }

}
