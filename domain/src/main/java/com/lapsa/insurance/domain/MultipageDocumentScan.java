package com.lapsa.insurance.domain;

import java.util.ArrayList;
import java.util.List;

public class MultipageDocumentScan extends BaseDomain implements DocumentScan {

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
