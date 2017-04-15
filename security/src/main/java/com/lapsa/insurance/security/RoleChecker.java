package com.lapsa.insurance.security;

public interface RoleChecker {
    boolean isUserInRole(Role role);
}
