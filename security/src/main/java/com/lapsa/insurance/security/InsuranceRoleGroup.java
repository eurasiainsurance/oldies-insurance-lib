package com.lapsa.insurance.security;

import com.lapsa.utils.security.SecurityRoleGroup;

public enum InsuranceRoleGroup implements SecurityRoleGroup {

    VIEW_OWN_OWNED(InsuranceRole.PARTNER),

    VIEWERS(
	    InsuranceRole.PARTNER,
	    InsuranceRole.REPORTER,
	    InsuranceRole.SPECIALIST,
	    InsuranceRole.SUPERVISOR),

    CHANGERS(
	    InsuranceRole.SPECIALIST,
	    InsuranceRole.SUPERVISOR),

    CLOSERS(InsuranceRole.SUPERVISOR);

    private final InsuranceRole[] roles;

    private InsuranceRoleGroup(InsuranceRole... roles) {
	this.roles = roles;
    }

    @Override
    public InsuranceRole[] getRoles() {
	return roles;
    }
}
