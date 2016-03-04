package kz.theeurasia.policy.domain;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.UUID;

public class UploadedImage {

    private final UUID id = UUID.randomUUID();

    private final String fileName;
    private final String mimeType;
    private final byte[] content;
    private final long size;

    public UploadedImage(String fileName, String mimeType, byte[] content) {
	this.fileName = fileName;
	this.mimeType = mimeType;
	this.content = content;
	this.size = content.length;
    }

    public UploadedImage(String fileName, String mimeType, byte[] content, long size) {
	this.fileName = fileName;
	this.mimeType = mimeType;
	this.content = content;
	this.size = size;
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
	return id.toString().replaceAll("-", "_");
    }

    public InputStream asStream() {
	return new ByteArrayInputStream(content);
    }

    // GENERATED

    public UUID getId() {
	return id;
    }

    public String getFileName() {
	return fileName;
    }

    public String getMimeType() {
	return mimeType;
    }

    public byte[] getContent() {
	return content;
    }

    public long getSize() {
	return size;
    }

}
