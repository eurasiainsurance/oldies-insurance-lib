package test.com.lapsa.insurance.elements;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public abstract class EnumTypeMessagesBundleTest<T extends Enum<?>> extends BaseMessagesBundleTest {

    @Test
    public void testRussianBundle() {
	testBundle(getBundleBaseName(), LANG_RU);
    }

    @Test
    public void testEnglishBundle() {
	testBundle(getBundleBaseName(), LANG_EN);
    }

    @Test
    public void testKazakhBundle() {
	testBundle(getBundleBaseName(), LANG_KK);
    }

    protected abstract T[] getAllEnumValues();

    protected abstract String getBundleBaseName();

    protected void testBundle(String bundleBaseName, String languageTag) {
	Locale locale = getLocale(languageTag);
	ResourceBundle resourceBundle = getResourceBundle(bundleBaseName, locale);
	for (T c : getAllEnumValues()) {
	    String name = resourceBundle.getString(String.format("%s.%s", c.getClass().getName(), c.name()));
	    assertThat(name, not(nullValue()));
	}
    }
}
