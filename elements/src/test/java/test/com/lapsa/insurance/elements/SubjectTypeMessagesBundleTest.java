package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.SubjectType;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class SubjectTypeMessagesBundleTest extends EnumTypeMessagesBundleTest<SubjectType> {

    @Override
    protected SubjectType[] getAllEnumValues() {
	return SubjectType.values();
    }
}
