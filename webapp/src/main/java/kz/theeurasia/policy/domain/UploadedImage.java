package kz.theeurasia.policy.domain;

import java.util.UUID;

import org.primefaces.model.UploadedFile;

public class UploadedImage {
    private final UUID id = UUID.randomUUID();

    private final UploadedFile file;

    public UploadedImage(UploadedFile file) {
	this.file = file;
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

    // GENERATED

    public UUID getId() {
	return id;
    }

    public UploadedFile getFile() {
	return file;
    }
}
