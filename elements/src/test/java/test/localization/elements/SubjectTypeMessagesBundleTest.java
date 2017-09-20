package test.localization.elements;

import com.lapsa.insurance.elements.SubjectType;

import test.localization.EnumTypeMessagesBundleTest;

public class SubjectTypeMessagesBundleTest extends EnumTypeMessagesBundleTest<SubjectType> {

    @Override
    protected SubjectType[] getAllEnumValues() {
	return SubjectType.values();
    }
}
