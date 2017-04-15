package com.lapsa.insurance.security;

import javax.faces.context.FacesContext;

class FacesContextChecker implements RoleChecker {

    private final FacesContext facesContext;

    FacesContextChecker(FacesContext facesContext) {
	this.facesContext = facesContext;
    }

    @Override
    public boolean isUserInRole(Role role) {
	return facesContext.getExternalContext().isUserInRole(role.name());
    }
}