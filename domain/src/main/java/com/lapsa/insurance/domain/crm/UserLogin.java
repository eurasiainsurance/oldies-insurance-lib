package com.lapsa.insurance.domain.crm;

import com.lapsa.insurance.domain.BaseEntity;

public class UserLogin extends BaseEntity<Integer> {
    private static final long serialVersionUID = -3456756685893976599L;
    private static final int PRIME = 164;
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
    private User user;

    // GENERATED

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }
}
