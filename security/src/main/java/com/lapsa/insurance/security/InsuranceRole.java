package com.lapsa.insurance.security;

import com.lapsa.utils.security.SecurityRole;

public final class InsuranceRole implements SecurityRole {

    public static final String ADMIN = "admin";
    public static final String SPECIALIST = "specialist";
    public static final String AGENT = "agent";

    public static final InsuranceRole ADMIN_ROLE = new InsuranceRole(ADMIN);
    public static final InsuranceRole SPECIALIST_ROLE = new InsuranceRole(SPECIALIST);
    public static final InsuranceRole AGENT_ROLE = new InsuranceRole(AGENT);

    private final String name;

    private InsuranceRole(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return name;
    }

    @Override
    public SecurityRole[] getRoles() {
	return new SecurityRole[] { this };
    }

    @Override
    public String name() {
	return name;
    }

    @Override
    public int hashCode() {
	return 17 * name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null)
	    return false;
	if (obj == this)
	    return true;
	if (!(obj instanceof InsuranceRole))
	    return false;
	InsuranceRole that = (InsuranceRole) obj;
	return name.equals(that.name);
    }
}
