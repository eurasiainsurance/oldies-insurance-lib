package test.localization;

import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

import com.lapsa.insurance.elements.CancelationReason;
import com.lapsa.insurance.elements.CascoCarAgeClass;
import com.lapsa.insurance.elements.CascoDeductibleFullRate;
import com.lapsa.insurance.elements.CascoDeductiblePartialRate;
import com.lapsa.insurance.elements.DeliveryTimeSlot;
import com.lapsa.insurance.elements.IdentityCardType;
import com.lapsa.insurance.elements.InsuranceClassType;
import com.lapsa.insurance.elements.InsuranceLocalizedElement;
import com.lapsa.insurance.elements.InsuranceProductType;
import com.lapsa.insurance.elements.InsuranceRequestType;
import com.lapsa.insurance.elements.InsuredAgeAndExpirienceClass;
import com.lapsa.insurance.elements.InsuredAgeClass;
import com.lapsa.insurance.elements.InsuredExpirienceClass;
import com.lapsa.insurance.elements.MaritalStatus;
import com.lapsa.insurance.elements.ObtainingMethod;
import com.lapsa.insurance.elements.ObtainingStatus;
import com.lapsa.insurance.elements.PaymentMethod;
import com.lapsa.insurance.elements.PaymentStatus;
import com.lapsa.insurance.elements.PolicyTemporaryEntryTimeCategory;
import com.lapsa.insurance.elements.ProgressStatus;
import com.lapsa.insurance.elements.RequestSource;
import com.lapsa.insurance.elements.RequestStatus;
import com.lapsa.insurance.elements.Sex;
import com.lapsa.insurance.elements.SteeringWheelLocation;
import com.lapsa.insurance.elements.SubjectType;
import com.lapsa.insurance.elements.TransactionProblem;
import com.lapsa.insurance.elements.TransactionStatus;
import com.lapsa.insurance.elements.VehicleAgeClass;
import com.lapsa.insurance.elements.VehicleClass;
import com.lapsa.insurance.elements.WhoIsInsurant;

public class MessagesBundleExceedTest extends BaseMessagesBundleTest {

    public static final String BUNDLE_BASENAME = InsuranceLocalizedElement.BUNDLE_BASENAME;

    @Test
    public void testNoExcessRecordsRussian() {
	Locale locale = getLocale(LANG_RU);
	ResourceBundle resources = getResourceBundle(BUNDLE_BASENAME, locale);
	testBundle(resources);
    }

    @Test
    public void testNoExcessRecordsEnglish() {
	Locale locale = getLocale(LANG_EN);
	ResourceBundle resources = getResourceBundle(BUNDLE_BASENAME, locale);
	testBundle(resources);
    }

    @Test
    public void testNoExcessRecordsKazakh() {
	Locale locale = getLocale(LANG_KK);
	ResourceBundle resources = getResourceBundle(BUNDLE_BASENAME, locale);
	testBundle(resources);
    }

    private void testBundle(ResourceBundle resources) {
	Enumeration<String> keys = resources.getKeys();
	while (keys.hasMoreElements()) {
	    String key = keys.nextElement();
	    // CRM
	    if (findByFullName(InsuranceRequestType.values(), key) != null)
		continue;
	    if (findByFullName(ObtainingStatus.values(), key) != null)
		continue;
	    if (findByFullName(PaymentStatus.values(), key) != null)
		continue;
	    if (findByFullName(ProgressStatus.values(), key) != null)
		continue;
	    if (findByFullName(RequestStatus.values(), key) != null)
		continue;
	    if (findByFullName(RequestSource.values(), key) != null)
		continue;
	    if (findByFullName(TransactionProblem.values(), key) != null)
		continue;
	    if (findByFullName(TransactionStatus.values(), key) != null)
		continue;
	    // ELEMENTS
	    if (findByFullName(CancelationReason.values(), key) != null)
		continue;
	    if (findByFullName(CascoCarAgeClass.values(), key) != null)
		continue;
	    if (findByFullName(CascoDeductibleFullRate.values(), key) != null)
		continue;
	    if (findByFullName(CascoDeductiblePartialRate.values(), key) != null)
		continue;
	    if (findByFullName(DeliveryTimeSlot.values(), key) != null)
		continue;
	    if (findByFullName(IdentityCardType.values(), key) != null)
		continue;
	    if (findByFullName(InsuranceProductType.values(), key) != null)
		continue;
	    if (findByFullName(InsuranceClassType.values(), key) != null)
		continue;
	    if (findByFullName(InsuredAgeAndExpirienceClass.values(), key) != null)
		continue;
	    if (findByFullName(InsuredAgeClass.values(), key) != null)
		continue;
	    if (findByFullName(InsuredExpirienceClass.values(), key) != null)
		continue;
	    if (findByFullName(MaritalStatus.values(), key) != null)
		continue;
	    if (findByFullName(ObtainingMethod.values(), key) != null)
		continue;
	    if (findByFullName(PaymentMethod.values(), key) != null)
		continue;
	    if (findByFullName(PolicyTemporaryEntryTimeCategory.values(), key) != null)
		continue;
	    if (findByFullName(Sex.values(), key) != null)
		continue;
	    if (findByFullName(SteeringWheelLocation.values(), key) != null)
		continue;
	    if (findByFullName(SubjectType.values(), key) != null)
		continue;
	    if (findByFullName(VehicleAgeClass.values(), key) != null)
		continue;
	    if (findByFullName(VehicleClass.values(), key) != null)
		continue;
	    if (findByFullName(WhoIsInsurant.values(), key) != null)
		continue;
	    fail(String.format("Resource bunddle key '%1$s' is outbinded", key));
	}
    }

    private <T extends Enum<?>> T findByFullName(T[] values, String key) {
	for (T c : values) {
	    String name = String.format("%s.%s", c.getClass().getName(), c.name());
	    if (name.equals(key))
		return c;
	    String shrt = String.format("%s.%s.short", c.getClass().getName(), c.name());
	    if (shrt.equals(key))
		return c;
	}
	return null;
    }
}
