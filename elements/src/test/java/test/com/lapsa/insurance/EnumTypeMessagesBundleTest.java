package test.com.lapsa.insurance;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Test;

import com.lapsa.insurance.ElementsBundleBase;

public abstract class EnumTypeMessagesBundleTest<T extends ElementsBundleBase> extends BaseMessagesBundleTest {

    @Test
    public void testRussianBundle() {
	testBundle(LANG_RU);
    }

    @Test
    public void testEnglishBundle() {
	testBundle(LANG_EN);
    }

    @Test
    public void testKazakhBundle() {
	testBundle(LANG_KK);
    }

    protected abstract T[] getAllEnumValues();

    protected void testBundle(String languageTag) {
	Locale locale = getLocale(languageTag);
	for (T c : getAllEnumValues()) {
	    try {
		String displayName = c.displayName(locale);
		assertThat(displayName, not(nullValue()));
	    } catch (IllegalArgumentException e) {
		fail(String.format("Missing display name for %1$s", c));
	    }
	}
    }
}
