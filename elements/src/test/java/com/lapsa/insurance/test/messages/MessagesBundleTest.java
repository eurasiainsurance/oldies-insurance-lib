package com.lapsa.insurance.test.messages;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

import com.lapsa.insurance.elements.BundleBase;
import com.lapsa.insurance.elements.CancelationReason;
import com.lapsa.insurance.elements.IdentityCardType;
import com.lapsa.insurance.elements.InsuranceClassType;
import com.lapsa.insurance.elements.InsuredAgeClass;
import com.lapsa.insurance.elements.InsuredAgeAndExpirienceClass;
import com.lapsa.insurance.elements.InsuredExpirienceClass;
import com.lapsa.insurance.elements.MaritalStatus;
import com.lapsa.insurance.elements.Sex;
import com.lapsa.insurance.elements.SteeringWheelLocation;
import com.lapsa.insurance.elements.SubjectType;
import com.lapsa.insurance.elements.VehicleAgeClass;
import com.lapsa.insurance.elements.VehicleClass;
import com.lapsa.insurance.elements.WhoIsInsurant;

public class MessagesBundleTest {

    @Test
    public void testNoExcessRecordsRussian() {
	Locale locale = Locale.forLanguageTag("ru");
	assertThat(locale.getLanguage(), allOf(not(nullValue()), is("ru")));
	ResourceBundle resources = ResourceBundle.getBundle(BundleBase.BUNDLE_BASENAME, locale);
	assertThat(resources, not(nullValue()));
	assertThat(resources.getString("com.lapsa.insurance.elements.InsuranceClassType.CLASS_3"),
		allOf(not(nullValue()), is("Класс 3")));
	testBundle(resources);
    }

    @Test
    public void testNoExcessRecordsEnglish() {
	Locale locale = Locale.forLanguageTag("en");
	assertThat(locale.getLanguage(), allOf(not(nullValue()), is("en")));
	ResourceBundle resources = ResourceBundle.getBundle(BundleBase.BUNDLE_BASENAME, locale);
	assertThat(resources, not(nullValue()));
	assertThat(resources.getString("com.lapsa.insurance.elements.InsuranceClassType.CLASS_3"),
		allOf(not(nullValue()), is("Class 3")));
	testBundle(resources);
    }

    private void testBundle(ResourceBundle resources) {
	Enumeration<String> keys = resources.getKeys();
	while (keys.hasMoreElements()) {
	    String key = keys.nextElement();
	    if (findByFullName(CancelationReason.values(), key) != null)
		continue;
	    if (findByFullName(IdentityCardType.values(), key) != null)
		continue;
	    if (findByFullName(InsuranceClassType.values(), key) != null)
		continue;
	    if (findByFullName(InsuredAgeAndExpirienceClass.values(), key) != null)
		continue;
	    if (findByFullName(MaritalStatus.values(), key) != null)
		continue;
	    if (findByFullName(Sex.values(), key) != null)
		continue;
	    if (findByFullName(VehicleAgeClass.values(), key) != null)
		continue;
	    if (findByFullName(VehicleClass.values(), key) != null)
		continue;
	    if (findByFullName(SubjectType.values(), key) != null)
		continue;
	    if (findByFullName(InsuredAgeClass.values(), key) != null)
		continue;
	    if (findByFullName(InsuredExpirienceClass.values(), key) != null)
		continue;
	    if (findByFullName(SteeringWheelLocation.values(), key) != null)
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
	}
	return null;
    }
}
