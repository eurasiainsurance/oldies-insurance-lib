package com.lapsa.insurance.domain.crm;

import java.util.ArrayList;
import java.util.List;

import com.lapsa.insurance.domain.BaseEntity;

public class User extends BaseEntity<Integer> {
    private static final long serialVersionUID = -8270933167719645431L;
    private static final int PRIME = 59;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private String name;
    private String email;
    private boolean hidden;

    private List<UserLogin> logins = new ArrayList<>();

    private List<UserGroup> groups;


    public String getDefaultLogin() {
	if (logins == null || logins.isEmpty())
	    return null;
	return logins.iterator().next().getName();
    }

    public UserLogin addLogin(UserLogin userLogin) {
	if (userLogin == null)
	    throw new NullPointerException("Value must not be null");
	if (userLogin.getUser() != null)
	    userLogin.getUser().removeLogin(userLogin);
	if (logins == null)
	    logins = new ArrayList<>();
	logins.add(userLogin);
	userLogin.setUser(this);
	return userLogin;
    }

    public UserLogin removeLogin(UserLogin userLogin) {
	if (userLogin == null)
	    throw new NullPointerException("Value must not be null");
	userLogin.setUser(null);
	if (logins != null) // nothing to remove from
	    logins.remove(userLogin);
	return userLogin;
    }

    // GENERATED

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public List<UserLogin> getLogins() {
	return logins;
    }

    public void setLogins(List<UserLogin> logins) {
	this.logins = logins;
    }

    public boolean isHidden() {
	return hidden;
    }

    public void setHidden(boolean hidden) {
	this.hidden = hidden;
    }

    public List<UserGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<UserGroup> groups) {
        this.groups = groups;
    }
}
