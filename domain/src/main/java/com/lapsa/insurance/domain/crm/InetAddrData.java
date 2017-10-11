package com.lapsa.insurance.domain.crm;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.Locale;
import java.util.StringJoiner;

import com.lapsa.insurance.domain.BaseDomain;

import tech.lapsa.java.commons.function.MyOptionals;

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

    @Override
    public String displayName(DisplayNameVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(INET_ADDR_DATA.displayName(variant, locale));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	MyOptionals.of(inetAddress) //
		.ifPresent(sj::add);

	MyOptionals.of(inetHost) //
		.map(INET_ADDR_DATA_HOST.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.toString();
    }

    // GENERATED

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
