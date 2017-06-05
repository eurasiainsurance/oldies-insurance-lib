package com.lapsa.insurance.domain.crm;

import java.util.List;

import com.lapsa.insurance.domain.BaseEntity;

public class UserGroup extends BaseEntity<Integer> {
    private static final long serialVersionUID = -8270933167719645431L;
    private static final int PRIME = 197;
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
    private List<User> members;

    // GENERATED

    public List<User> getMembers() {
	return members;
    }

    public void setMembers(List<User> members) {
	this.members = members;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

}
