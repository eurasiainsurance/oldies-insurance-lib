package com.lapsa.insurance.domain.crm;

import com.lapsa.insurance.domain.BaseDomain;

public class InetAddrData extends BaseDomain {
    private static final long serialVersionUID = 7955301639535366812L;

    private static final int PRIME = 181;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private String inetAddress;
    private String inetHost;

    public InetAddrData() {
    }

    public InetAddrData(String inetAddress, String inetHost) {
	this.inetAddress = inetAddress;
	this.inetHost = inetHost;
    }

    public String getInetAddress() {
	return inetAddress;
    }

    public void setInetAddress(String inetAddress) {
	this.inetAddress = inetAddress;
    }

    public String getInetHost() {
	return inetHost;
    }

    public void setInetHost(String inetHost) {
	this.inetHost = inetHost;
    }

}
