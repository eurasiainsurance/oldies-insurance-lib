package com.lapsa.insurance;

public interface ElementsBundleBase {
    public static final String BUNDLE_BASENAME = "ElementsLocalization";
    public static final String BUNDLE_VAR = "el";

    String name();

    default String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }

}
