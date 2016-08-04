package com.lapsa.insurance.domain;

import java.io.Serializable;

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

    @Override
    public String toString() {
	return "Lat:" + latitude + ", Lng:" + longitude;
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