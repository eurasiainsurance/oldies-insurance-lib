package com.lapsa.insurance.test.messages;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

import com.lapsa.insurance.elements.WhoIsInsurant;

public class WhoIsInsurantMessagesBundleTest {

    @Test
    public void testRussianBundle() {
	ResourceBundle resources = ResourceBundle.getBundle(WhoIsInsurant.BUNDLE_BASENAME, Locale.forLanguageTag("ru"));
	assertThat(resources, not(nullValue()));
	testBundle(resources);
    }

    @Test
    public void testEnglishBundle() {
	ResourceBundle resources = ResourceBundle.getBundle(WhoIsInsurant.BUNDLE_BASENAME, Locale.forLanguageTag("en"));
	assertThat(resources, not(nullValue()));
	testBundle(resources);
    }

    private void testBundle(ResourceBundle resources) {
	assertThat(resources, not(nullValue()));
	for (WhoIsInsurant c : WhoIsInsurant.values()) {
	    String name = resources.getString(String.format("%s.%s", c.getClass().getName(), c.name()));
	    assertThat(name, not(nullValue()));
	}
    }
}
