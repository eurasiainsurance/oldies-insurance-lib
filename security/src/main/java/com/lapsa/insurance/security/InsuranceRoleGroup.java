package com.lapsa.insurance.security;

import com.lapsa.utils.security.SecurityRoleGroup;

public enum InsuranceRoleGroup implements SecurityRoleGroup {

    VIEW_OWN_OWNED(InsuranceRole.AGENT_ROLE),

    VIEWERS(
	    InsuranceRole.AGENT_ROLE,
	    InsuranceRole.SPECIALIST_ROLE,
	    InsuranceRole.ADMIN_ROLE),

    CHANGERS(
	    InsuranceRole.SPECIALIST_ROLE,
	    InsuranceRole.ADMIN_ROLE),

    CLOSERS(InsuranceRole.ADMIN_ROLE);

    private final InsuranceRole[] roles;

    private InsuranceRoleGroup(InsuranceRole... roles) {
	this.roles = roles;
    }

    @Override
    public InsuranceRole[] getRoles() {
	return roles;
    }
}
