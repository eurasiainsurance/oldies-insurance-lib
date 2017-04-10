package test.com.lapsa.insurance.elements;

import com.lapsa.insurance.elements.PolicyTemporaryEntryTimeCategory;

import test.com.lapsa.insurance.EnumTypeMessagesBundleTest;

public class PolicyTemporaryEntryTimeCategoryMessagesBundleTest
	extends EnumTypeMessagesBundleTest<PolicyTemporaryEntryTimeCategory> {

    @Override
    protected PolicyTemporaryEntryTimeCategory[] getAllEnumValues() {
	return PolicyTemporaryEntryTimeCategory.values();
    }

    @Override
    protected String getBundleBaseName() {
	return PolicyTemporaryEntryTimeCategory.BUNDLE_BASENAME;
    }
}
