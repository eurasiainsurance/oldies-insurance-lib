package kz.theeurasia.policy.domain;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.imageio.ImageIO;

public class UploadedImage {

    private final String id = UUID.randomUUID().toString();
    private final String fileName;
    private final String mimeType;
    private final byte[] content;
    private final int width;
    private final int height;
    private final byte[] thumnail;
    private final int thumbnailWidth;
    private final int thumbnailHeight;

    private String comments;
    private final int type;

    public enum ResizeMode {
	BY_HEIGHT, BY_WIDTH;
    }

    public UploadedImage(String fileName, String mimeType, byte[] content) throws IOException {
	this(fileName, mimeType, content, 100, ResizeMode.BY_HEIGHT);
    }

    private BufferedImage readImage(byte[] content) throws IOException {
	try (InputStream in = new ByteArrayInputStream(content)) {
	    BufferedImage image = ImageIO.read(in);
	    return image;
	} finally {
	}
    }

    private byte[] resizeImage(BufferedImage origin, int width, int height) throws IOException {
	BufferedImage thumb = new BufferedImage(width, height, origin.getType());
	Graphics2D g = thumb.createGraphics();
	g.drawImage(origin, 0, 0, width, height, null);
	g.dispose();
	g.setComposite(AlphaComposite.Src);
	g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
	    ImageIO.write(thumb, "png", baos);
	    return baos.toByteArray();
	} finally {
	}
    }

    public UploadedImage(String fileName, String mimeType, byte[] content, int resizeTo, ResizeMode resizeMode)
	    throws IOException {
	this.fileName = fileName;
	this.mimeType = mimeType;
	this.content = content;

	BufferedImage origin = readImage(content);
	this.width = origin.getWidth();
	this.height = origin.getHeight();
	this.type = origin.getType();

	int thumbWidth;
	int thumbHeight;
	switch (resizeMode) {
	case BY_WIDTH:
	    thumbWidth = resizeTo;
	    thumbHeight = height * thumbWidth / width;
	    break;
	case BY_HEIGHT:
	default:
	    thumbHeight = resizeTo;
	    thumbWidth = width * thumbHeight / height;
	    break;
	}
	this.thumbnailWidth = thumbWidth;
	this.thumbnailHeight = thumbHeight;
	this.thumnail = resizeImage(origin, thumbnailWidth, thumbnailHeight);
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
	return content.length;
    }

    public String getComments() {
	return comments;
    }

    public void setComments(String comments) {
	this.comments = comments;
    }

    public int getWidth() {
	return width;
    }

    public int getHeight() {
	return height;
    }

    public int getType() {
	return type;
    }

    public byte[] getThumnail() {
	return thumnail;
    }

    public int getThumbnailWidth() {
	return thumbnailWidth;
    }

    public int getThumbnailHeight() {
	return thumbnailHeight;
    }
}
