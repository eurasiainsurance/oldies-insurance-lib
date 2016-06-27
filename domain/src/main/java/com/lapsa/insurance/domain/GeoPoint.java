package com.lapsa.insurance.domain;

import java.io.Serializable;

public class GeoPoint extends BaseDomain implements Serializable {
    private static final long serialVersionUID = -2196615504671366442L;
    private static final int PRIME = 19;
    private static final int MULTIPLIER = 19;

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

//    @Override
//    public int hashCode() {
//	final int prime = 31;
//	int result = 1;
//	long temp;
//	temp = Double.doubleToLongBits(latitude);
//	result = prime * result + (int) (temp ^ (temp >>> 32));
//	temp = Double.doubleToLongBits(longitude);
//	result = prime * result + (int) (temp ^ (temp >>> 32));
//	return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//	if (this == obj)
//	    return true;
//	if (obj == null)
//	    return false;
//	if (getClass() != obj.getClass())
//	    return false;
//	GeoPoint other = (GeoPoint) obj;
//	if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
//	    return false;
//	if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
//	    return false;
//	return true;
//    }

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
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