package com.lapsa.insurance.domain.crm;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.Locale;
import java.util.StringJoiner;

import com.lapsa.insurance.domain.Domain;

import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.patterns.domain.HashCodePrime;

@HashCodePrime(181)
public class InetAddrData extends Domain {

    private static final long serialVersionUID = 1L;

    private String inetAddress;
    private String inetHost;

    public InetAddrData() {
    }

    public InetAddrData(String inetAddress, String inetHost) {
	this.inetAddress = inetAddress;
	this.inetHost = inetHost;
    }

    @Override
    public String localized(LocalizationVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(INET_ADDR_DATA.localized(variant, locale));

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
