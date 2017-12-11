package com.lapsa.insurance.domain;

import java.util.Arrays;

import com.lapsa.donkeyfaces.model.Image;
import com.lapsa.donkeyfaces.validators.FileSizeMeasure;
import com.lapsa.donkeyfaces.validators.MaxImageFileSize;

import tech.lapsa.java.commons.function.MyFunctions;
import tech.lapsa.java.commons.function.MyObjects;

public abstract class SidedScannedDocument extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @MaxImageFileSize(measure = FileSizeMeasure.MB, value = 10)
    private Image frontside;

    @MaxImageFileSize(measure = FileSizeMeasure.MB, value = 10)
    private Image backside;

    @Override
    public void unlazy() {
	super.unlazy();
	Arrays.asList(getFrontside(), getBackside()) //
		.stream() //
		.filter(MyObjects::nonNull) //
		.map(Image::getContent)
		.forEach(MyFunctions.voidConsumer());
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
}
