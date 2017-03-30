package com.lapsa.insurance.domain;

public class CallbackRequest extends Request {
    private static final long serialVersionUID = 4285018638039289108L;
    private static final int PRIME = 173;
    private static final int MULTIPLIER = PRIME;

    private String comments;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    // GENERATED

    public String getComments() {
	return comments;
    }

    public void setComments(String comments) {
	this.comments = comments;
    }
}
