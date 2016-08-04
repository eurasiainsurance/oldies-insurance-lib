package com.lapsa.insurance.domain;

import java.util.ArrayList;
import java.util.List;

public class MultipageDocumentScan extends BaseDomain implements DocumentScan {
    private static final long serialVersionUID = 722737247502872835L;
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

    private List<UploadedImage> scanCopies = new ArrayList<>();

    @Override
    public UploadedImage[] getScans() {
	if (scanCopies != null)
	    return scanCopies.toArray(new UploadedImage[0]);
	return new UploadedImage[0];
    }

    // GENERATED

    public List<UploadedImage> getScanCopies() {
	return scanCopies;
    }

    public void setScanCopies(List<UploadedImage> scanCopies) {
	this.scanCopies = scanCopies;
    }

}
