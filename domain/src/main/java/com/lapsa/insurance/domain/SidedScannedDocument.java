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
}
