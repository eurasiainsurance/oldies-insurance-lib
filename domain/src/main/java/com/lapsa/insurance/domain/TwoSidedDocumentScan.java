package com.lapsa.insurance.domain;

import com.lapsa.donkeyfaces.model.Image;
import com.lapsa.donkeyfaces.validators.FileSizeMeasure;
import com.lapsa.donkeyfaces.validators.MaxImageFileSize;

public class TwoSidedDocumentScan extends BaseDomain {
    private static final long serialVersionUID = 239502663275715827L;
    private static final int PRIME = 107;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    // @NotNullValue
    @MaxImageFileSize(measure = FileSizeMeasure.MB, value = 10)
    private Image frontside;

    // @NotNullValue
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
