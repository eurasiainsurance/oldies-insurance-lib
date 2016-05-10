package com.lapsa.insurance.domain;

import java.util.UUID;

public class UploadedImage {

    private String id = UUID.randomUUID().toString();

    private String fileName;
    private String mimeType;
    private String comments;

    private ImageContent original;
    private ImageContent thumbnail;

    public UploadedImage() {
    }

    public UploadedImage(String fileName, String mimeType, String comments, ImageContent original,
	    ImageContent thumbnail) {
	this.fileName = fileName;
	this.mimeType = mimeType;
	this.comments = comments;
	this.original = original;
	this.thumbnail = thumbnail;
    }

    public UploadedImage(String fileName, String mimeType, ImageContent original,
	    ImageContent thumbnail) {
	this.fileName = fileName;
	this.mimeType = mimeType;
	this.original = original;
	this.thumbnail = thumbnail;
    }

    @Override
    public int hashCode() {
	return this.getClass().hashCode() * id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	return obj != null && this.getClass().isInstance(obj) && getId().equals((this.getClass().cast(obj)).getId());
    }

    public String getSafeId() {
	return id.replaceAll("-", "_");
    }

    // GENERATED

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getFileName() {
	return fileName;
    }

    public void setFileName(String fileName) {
	this.fileName = fileName;
    }

    public String getMimeType() {
	return mimeType;
    }

    public void setMimeType(String mimeType) {
	this.mimeType = mimeType;
    }

    public String getComments() {
	return comments;
    }

    public void setComments(String comments) {
	this.comments = comments;
    }

    public ImageContent getOriginal() {
	return original;
    }

    public void setOriginal(ImageContent original) {
	this.original = original;
    }

    public ImageContent getThumbnail() {
	return thumbnail;
    }

    public void setThumbnail(ImageContent thumbnail) {
	this.thumbnail = thumbnail;
    }
}
