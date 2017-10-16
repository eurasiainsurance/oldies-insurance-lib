package com.lapsa.insurance.domain;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.StringJoiner;

public class GeoPoint extends BaseDomain implements Serializable {
    private static final long serialVersionUID = -2196615504671366442L;
    private static final int PRIME = 19;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private double latitude;

    private double longitude;

    public GeoPoint() {
    }

    public GeoPoint(double latitude, double longitude) {
	this.latitude = latitude;
	this.longitude = longitude;
    }

    private static final NumberFormat GEO_LONG_NUMBER_FORMAT = NumberFormat.getNumberInstance();
    {
	GEO_LONG_NUMBER_FORMAT.setMinimumFractionDigits(6);
	GEO_LONG_NUMBER_FORMAT.setMaximumFractionDigits(6);
	GEO_LONG_NUMBER_FORMAT.setGroupingUsed(false);
    }

    @Override
    public String localized(LocalizationVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(GEO_POINT.localized(variant, locale));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	sj.add(GEO_POINT_LAT.localized(variant, locale) + ": " + GEO_LONG_NUMBER_FORMAT.format(latitude) + "°");
	sj.add(GEO_POINT_LNG.localized(variant, locale) + ": " + GEO_LONG_NUMBER_FORMAT.format(longitude) + "°");

	return sb.append(sj.toString()) //
		.toString();
    }

    // GENERATED

    public double getLatitude() {
	return latitude;
    }

    public void setLatitude(double latitude) {
	this.latitude = latitude;
    }

    public double getLongitude() {
	return longitude;
    }

    public void setLongitude(double longitude) {
	this.longitude = longitude;
    }
}