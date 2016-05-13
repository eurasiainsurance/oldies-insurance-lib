package com.lapsa.insurance.domain;

import java.util.ArrayList;
import java.util.List;

public class TwoSidedDocumentScan implements DocumentScan {

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
