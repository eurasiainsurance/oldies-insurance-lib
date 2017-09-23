package test.localization;

import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

import com.lapsa.insurance.domain.DisplayNameElements;

public class MessagesBundleExceedTest extends BaseMessagesBundleTest {

    public static final String BUNDLE_BASENAME = DisplayNameElements.BUNDLE_BASENAME;

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
	    if (findByFullName(DisplayNameElements.values(), key) != null)
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
