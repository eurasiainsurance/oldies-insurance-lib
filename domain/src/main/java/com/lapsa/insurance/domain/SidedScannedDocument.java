package com.lapsa.insurance.domain;

import com.lapsa.donkeyfaces.model.Image;
import com.lapsa.donkeyfaces.validators.FileSizeMeasure;
import com.lapsa.donkeyfaces.validators.MaxImageFileSize;

public abstract class SidedScannedDocument extends BaseEntity<Integer> {
    private static final long serialVersionUID = 3944590199706860072L;

    @MaxImageFileSize(measure = FileSizeMeasure.MB, value = 10)
    private Image frontside;

    @MaxImageFileSize(measure = FileSizeMeasure.MB, value = 10)
    private Image backside;

    // used for
    private final Scans scanProxy;

    public SidedScannedDocument() {
	scanProxy = new Scans() {
	    @Override
	    public Image getFrontside() {
		return SidedScannedDocument.this.getFrontside();
	    }

	    @Override
	    public void setFrontside(Image frontside) {
		SidedScannedDocument.this.setFrontside(frontside);
	    }

	    @Override
	    public Image getBackside() {
		return SidedScannedDocument.this.getBackside();
	    }

	    @Override
	    public void setBackside(Image backside) {
		SidedScannedDocument.this.setBackside(backside);
	    }
	};
    }

    interface Scans {
	Image getFrontside();

	void setFrontside(Image frontside);

	Image getBackside();

	void setBackside(Image backside);
    }

    // GENERATED

    public Image getFrontside() {
	return frontside;
    }

    public void setFrontside(Image frontside) {
	this.frontside = frontside;
    }

    public Image getBackside() {
	return backside;
    }

    public void setBackside(Image backside) {
	this.backside = backside;
    }

    public Scans getScan() {
	return scanProxy;
    }

}
