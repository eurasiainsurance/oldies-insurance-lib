package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.SubjectType;

public class SubjectTypeMessagesBundleTest extends EnumTypeMessagesBundleTest<SubjectType> {

    @Override
    protected SubjectType[] getAllEnumValues() {
	return SubjectType.values();
    }

    @Override
    protected String getBundleBaseName() {
	return SubjectType.BUNDLE_BASENAME;
    }

}
