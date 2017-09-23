package test.localization;

import com.lapsa.insurance.domain.DisplayNameElements;

public class DisplayNameElementsBundleTest extends EnumTypeMessagesBundleTest<DisplayNameElements> {

    @Override
    protected DisplayNameElements[] getAllEnumValues() {
	return DisplayNameElements.values();
    }
}
