package com.lapsa.insurance.domain;

import java.util.ArrayList;
import java.util.List;

public class TwoSidedDocumentScan extends BaseDomain implements DocumentScan {
    private static final long serialVersionUID = 239502663275715827L;
    private static final int PRIME = 107;
    private static final int MULTIPLIER = PRIME;

    private UploadedImage frontside;
    private UploadedImage backside;

    @Override
    public UploadedImage[] getScans() {
	List<UploadedImage> ret = new ArrayList<>();
	if (frontside != null)
	    ret.add(frontside);
	if (backside != null)
	    ret.add(backside);
	return ret.toArray(new UploadedImage[0]);
    }

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    // GENERATED

    public UploadedImage getFrontside() {
	return frontside;
    }

    public void setFrontside(UploadedImage frontside) {
	this.frontside = frontside;
    }

    public UploadedImage getBackside() {
	return backside;
    }

    public void setBackside(UploadedImage backside) {
	this.backside = backside;
    }

}
