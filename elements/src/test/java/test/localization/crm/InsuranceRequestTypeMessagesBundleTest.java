package test.localization.crm;

import com.lapsa.insurance.elements.InsuranceRequestType;

import test.localization.EnumTypeMessagesBundleTest;

public class InsuranceRequestTypeMessagesBundleTest extends EnumTypeMessagesBundleTest<InsuranceRequestType> {

    @Override
    protected InsuranceRequestType[] getAllEnumValues() {
	return InsuranceRequestType.values();
    }
}
