package com.lapsa.insurance.domain.crm;

import com.lapsa.insurance.domain.BaseDomain;

public class UTMData extends BaseDomain {
    private static final long serialVersionUID = 2784081894656368503L;
    private static final int PRIME = 29;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private String source;
    private String medium;
    private String campaign;
    private String content;
    private String term;

    // GENERATED

    public String getSource() {
	return source;
    }

    public void setSource(String source) {
	this.source = source;
    }

    public String getMedium() {
	return medium;
    }

    public void setMedium(String medium) {
	this.medium = medium;
    }

    public String getCampaign() {
	return campaign;
    }

    public void setCampaign(String campaign) {
	this.campaign = campaign;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public String getTerm() {
	return term;
    }

    public void setTerm(String term) {
	this.term = term;
    }
}
