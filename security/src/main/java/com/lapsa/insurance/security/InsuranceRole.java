package com.lapsa.insurance.security;

import com.lapsa.utils.security.Role;

public final class InsuranceRole implements Role {

    public static final String PARTNER_NAME = "partner";
    public static final String SUPERVISOR_NAME = "supervisor";
    public static final String SPECIALIST_NAME = "specialist";
    public static final String REPORTER_NAME = "reporter";
    public static final String APIUSER_NAME = "apiuser";

    public static InsuranceRole APIUSER = new InsuranceRole(APIUSER_NAME);
    public static InsuranceRole REPORTER = new InsuranceRole(REPORTER_NAME);
    public static InsuranceRole SPECIALIST = new InsuranceRole(SPECIALIST_NAME);
    public static InsuranceRole SUPERVISOR = new InsuranceRole(SUPERVISOR_NAME);
    public static InsuranceRole PARTNER = new InsuranceRole(PARTNER_NAME);

    private final String name;

    private InsuranceRole(String name) {
	this.name = name;
    }

    @Override
    public Role[] getRoles() {
	return new Role[] { this };
    }

    @Override
    public String name() {
	return name;
    }

}
